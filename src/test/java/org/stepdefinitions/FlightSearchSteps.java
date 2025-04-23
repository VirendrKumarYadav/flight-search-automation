package org.stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.pages.FlightSearchPage;
import org.testng.asserts.SoftAssert;
import org.utils.DriverManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class FlightSearchSteps {
    WebDriver driver;
    FlightSearchPage flightSearchPage;
    SoftAssert softAssert;

    @Given("I open the flight search page")
    public void i_open_the_flight_search_page() {
        driver = DriverManager.getDriver();
        driver.get("https://www.booking.com/flights/index.en-gb.html");
        flightSearchPage = new FlightSearchPage(driver);
    }

    @When("I enter {string} as the departure city")
    public void i_enter_as_the_departure_city(String from) {
        flightSearchPage.clickFromButton();
        flightSearchPage.enterFromCity(from);
        flightSearchPage.selectCity();
    }

    @When("I enter {string} as the destination city")
    public void i_enter_as_the_destination_city(String to) {
        flightSearchPage.clickToButton();
        flightSearchPage.enterToCity(to);
        flightSearchPage.selectCity();
    }

    @When("I select {string} as the departure date")
    public void i_select_as_the_departure_date(String dateString) {
        LocalDate date;
        flightSearchPage.clickOnCalender();
        if (dateString.equalsIgnoreCase("today")) {
            date = LocalDate.now();
        } else if (dateString.equalsIgnoreCase("tomorrow")) {
            date = LocalDate.now().plusDays(1);
        } else {
            try {
                date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Invalid date format. Use 'today', 'tomorrow' or yyyy-MM-dd format");
            }
        }
        flightSearchPage.selectDepartureDate(date);
    }



    @When("I click the search button")
    public void i_click_the_search_button() {
        flightSearchPage.clickSearchButton();
    }

    @Then("I should see flights from {string} to {string} for {string}")
    public void i_should_see_flights(String from, String to, String date) {
        boolean fromStatus = flightSearchPage.isFromSelected(from);
        boolean toStatus = flightSearchPage.isToSelected(to);
        softAssert = new SoftAssert();
        softAssert.assertEquals(fromStatus, true);
        softAssert.assertEquals(toStatus, true);
        softAssert.assertAll();

    }
}

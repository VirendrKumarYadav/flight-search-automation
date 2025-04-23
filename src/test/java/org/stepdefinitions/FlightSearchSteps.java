package org.stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pages.FlightSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FlightSearchSteps {
    WebDriver driver;
    FlightSearchPage flightSearchPage;

    @Given("I open the flight search page")
    public void i_open_the_flight_search_page() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.booking.com/flights/index.en-gb.html");
        flightSearchPage = new FlightSearchPage(driver);
    }

    @When("I enter {string} as the departure city")
    public void i_enter_as_the_departure_city(String from) {
        flightSearchPage.clickFromButton();

    }

    @When("I enter {string} as the destination city")
    public void i_enter_as_the_destination_city(String to) {
        flightSearchPage.clickToButton();
    }

    @When("I select {string} as the departure date")
    public void i_select_as_the_departure_date(String dateString) {
        LocalDate date = LocalDate.now();
        if (dateString.equalsIgnoreCase("tomorrow")) {
            date = date.plusDays(1);
        }

    }

    @When("I click the search button")
    public void i_click_the_search_button() {
        // Add logic to click search button
    }

    @Then("I should see flights from {string} to {string} for {string}")
    public void i_should_see_flights(String from, String to, String date) {
        // Add logic to verify flight results are shown
        driver.quit();
    }
}


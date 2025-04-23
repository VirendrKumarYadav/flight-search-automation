package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.NoSuchElementException;

public class FlightSearchPage {
    WebDriver driver;

    public FlightSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search_type_option_ROUNDTRIP")
    private WebElement roundTripRadio;

    @FindBy(id = "search_type_option_ONEWAY")
    private WebElement oneWayRadio;

    @FindBy(id = "search_type_option_MULTISTOP")
    private WebElement multiCityRadio;

    @FindBy(css = "[data-ui-name='input_location_from_segment_0']")
    private WebElement fromButton;

    @FindBy(css = "[data-ui-name='input_location_to_segment_0']")
    private WebElement toButton;

    @FindBy(xpath = "//button[@data-ui-name='input_location_from_segment_0']//span/b[contains(text(),'DEL')]")
    private WebElement fromText;

    @FindBy(xpath = "//button[@data-ui-name='input_location_to_segment_0']//span/b[contains(text(),'DEL')]")
    private WebElement toText;

    @FindBy(xpath = "//ul[@id='flights-searchbox_suggestions']//li[position()=1]//input")
    private WebElement selectFirstCity;

    @FindBy(xpath = "//div[contains(@class,'LocationsDropDown-module__container')]//button")
    private WebElement clearSelectedCity;

    @FindBy(xpath = "//input[@placeholder='Airport or city']")
    private WebElement searchBox;

    @FindBy(css = "[data-ui-name='button_search_submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//ul[@id='flights-searchbox_suggestions']")
    private WebElement ddOptions;

    @FindBy(xpath = "(//div[contains(@class,'Calendar-module__monthWrapper')]/h3)[1]")
    private WebElement displayedMonth;

    @FindBy(xpath = "//button[contains(@class,'Calendar-module__control--next')]")
    private WebElement nextMonthBtn;

    @FindBy(xpath = "//button[contains(@class,'Calendar-module__control--prev')]")
    private WebElement prevMonthBtn;

    @FindBy(xpath = "//button[@placeholder='Depart - Return']")
    private WebElement dateBtn;

    @FindBy(xpath = "//h2[text()='Filters']")
    private WebElement filterBtn;

    public void selectTripType(String type) {
        switch (type.toLowerCase()) {
            case "roundtrip":
                roundTripRadio.click();
                break;
            case "oneway":
                oneWayRadio.click();
                break;
            case "multicity":
                multiCityRadio.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid trip type: " + type);
        }
    }

    public void clickFromButton() {
        fromButton.click();
        if (new WebDriverWait(driver, Duration.ofSeconds(20)).until(d -> clearSelectedCity.isDisplayed())) {
            clearSelectedCity.click();
        }
    }

    public void clickToButton() {
        toButton.click();
    }

    public void enterFromCity(String from) {
        searchBox.sendKeys(from);
    }

    public void enterToCity(String to) {
        searchBox.sendKeys(to);
    }

    public void selectCity() {
        if (new WebDriverWait(driver, Duration.ofSeconds(20)).until(d -> ddOptions.isDisplayed()))
            selectFirstCity.click();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public boolean isFromSelected(String from) {
        return driver.findElement(By.xpath("//button[@data-ui-name='input_location_from_segment_0']//span/b[contains(text(),'" + from + "')]")).isDisplayed();
    }

    public boolean isToSelected(String to) {
        return driver.findElement(By.xpath("//button[@data-ui-name='input_location_to_segment_0']//span/b[contains(text(),'" + to + "')]")).isDisplayed();
    }


    public void selectDepartureDate(LocalDate date) {
        navigateToMonth(date);
        selectDate(LocalDate.parse(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        selectDate(date);
    }

    private void navigateToMonth(LocalDate targetDate) {
        DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMMM yyyy", Locale.ENGLISH);

        while (true) {

            YearMonth displayed = YearMonth.parse(displayedMonth.getText(), monthYearFormatter);
            YearMonth target = YearMonth.from(targetDate);

            if (displayed.equals(target)) {
                break;
            } else if (displayed.isBefore(target)) {
                nextMonthBtn.click();
            } else {
                prevMonthBtn.click();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }

    private void selectDate(LocalDate date) {
        String dateStr = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        String xpath = String.format(
                "//span[@data-date='%s' and contains(@class,'Calendar-module__date--hoverable')]", dateStr
        );
        WebElement dateCell = driver.findElement(By.xpath(xpath));
        dateCell.click();
    }

    public void clickOnCalender()
    {
        dateBtn.click();
    }

    public boolean isFilterListOfFlight(){
        boolean status=false;
          if(filterBtn.isDisplayed()){
              status= filterBtn.isDisplayed();
          }

        return status;

    }
}


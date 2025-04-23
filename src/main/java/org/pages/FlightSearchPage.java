package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    }

    public void clickToButton() {
        toButton.click();
    }

    public void putInFromInput(String from){

    }
    public void putInToInput(String to){

    }
    public boolean isFromAirportCorrect(String code) {
        return fromText.getText().contains(code);
    }

    public boolean isToAirportCorrect(String code) {
        return toText.getText().contains(code);
    }
}

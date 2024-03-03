package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOut extends BasePage {
    public CheckOut(WebDriver driver) {
        super(driver);
    }

    private By namefiled = By.xpath(".//input[@name=\"user_data[fullname]\"]");
    private By NumberField = By.xpath(".//input[@id=\"litecheckout_phone\"]");

    private By AddressField = By.xpath(".//input[@id=\"litecheckout_s_address\"]");
    private By TermsAndConditions = By.xpath("//label[contains(text(), 'Select this check box')]/input[@type='checkbox']");

    private By PlaceOrderButton = By.xpath(".//button[@id=\"litecheckout_place_order\"]");

    public void EnterCustomerData(String name, String number) {
        WaitTillVisibleAndSendKeys(namefiled, name);
        WaitTillVisibleAndSendKeys(NumberField, number);
    }

    public void EnterDeliveryDetails(String address) {
        scrollTillVisible(AddressField);
        WaitTillVisibleAndSendKeys(AddressField, address);
    }

    public void CheckTermsAndConditions() {
        scrollTillVisible(TermsAndConditions);
        clickElement(TermsAndConditions);
    }

    public void PressPlaceOrderButton() {
        WaitTillVisibleAndClick(PlaceOrderButton);
    }

    private By ConfirmationMessage = By.xpath(".//div[@class=\"ty-checkout-complete__order-success\"]//p");

    public String GetConfirmationMessage() {
        WaitUntilVisibleElement(ConfirmationMessage);
        return getText(ConfirmationMessage);
    }
}

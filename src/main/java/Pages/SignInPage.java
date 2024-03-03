package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {
    public SignInPage(WebDriver driver) {
        super(driver);
    }

    private By EmailField = By.xpath("//input[@name=\"user_login\" and @type=\"text\"]");
    private By PasswordField = By.xpath("//input[@name=\"password\" and @type=\"password\"]");
    private By LoginButton = By.xpath("//button[@type=\"submit\" and @name=\"dispatch[auth.login]\"]");

    public void setEmailField(String email) {
        WaitTillVisibleAndSendKeys(EmailField, email);

    }

    public void setPasswordField(String password) {
        WaitTillVisibleAndSendKeys(PasswordField, password);

    }

    public void PressLoginButton() {
        WaitUntilElementBeClickable(LoginButton);
        clickElement(LoginButton);
    }
}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // SearchKeyWord
    private By SearchBar = By.xpath(".//input[@id=\"search_input\"]");
    private By AddToCartButton = By.xpath("//button[.//bdi[contains(text(), 'Add to cart')]]");
    private By CartIcon = By.xpath(".//a[@id=\"cart_icon_4700\"]");
    private By AssertCart = By.xpath(".//i/span[@class=\"ty-minicart-count\"]");
    private By ProfileIcon = By.xpath(".//div[@class=\"ut2-top-my-account hidden-phone \"]");
    private By RegisterButton = By.xpath
            ("//div[contains(@class, \"ty-account-info__buttons\")]" +
                    "/a[@href=\"https://egyptlaptop.com/profiles-add\" and contains(text(), \"Register\")]");
    private By FirstNameField = By.xpath("//input[@id=\"elm_6\"]");
    private By LastNameField = By.xpath("//input[@id=\"elm_7\"]");
    private By PhoneField = By.xpath("//input[@id=\"elm_9\"]");
    private By EmailField = By.xpath("//input[@id=\"email\"]");
    private By PasswordField = By.xpath("//input[@id=\"password1\"]");
    private By ConfirmPasswordField = By.xpath("//input[@id=\"password2\"]");
    private By SignUpButton = By.xpath
            ("//div[@class=\"ty-profile-field__buttons buttons-container\"]/button[@type=\"submit\"]");


    public void EnterKeyWord(String KeyWord) {
        WaitUntilVisibleElement(SearchBar);
        ClearAndSendKeys(SearchBar, KeyWord);

    }

    public void PressEnter() {
        driver.findElement(SearchBar).sendKeys(Keys.ENTER);
    }

    public ProductPage PressSelectedItem() {
        By Result_items = By.xpath(".//div[@class=\"ty-column4\"]");
        List<WebElement> result_items = driver.findElements(Result_items);
        result_items.get(0).click();
        return new ProductPage(driver);
    }


    public void PressRegisterButton() {
        WaitTillVisibleAndClick(ProfileIcon);
        WaitTillVisibleAndClick(RegisterButton);
    }

    public void EnterAccountDetails(String FirstName, String LastName, String Phone,
                                    String Email, String Password, String ConfirmPassword) {

        WaitTillVisibleAndSendKeys(FirstNameField, FirstName);
        WaitTillVisibleAndSendKeys(LastNameField, LastName);
        WaitTillVisibleAndSendKeys(PhoneField, Phone);
        WaitTillVisibleAndSendKeys(EmailField, Email);
        WaitTillVisibleAndSendKeys(PasswordField, Password);
        WaitTillVisibleAndSendKeys(ConfirmPasswordField, ConfirmPassword);
        WaitTillVisibleAndClick(SignUpButton);
    }

    public String AssertUserCreated() {
        return driver.getCurrentUrl();
    }

    //error message if user exists
    private By AlarmMessage = By.xpath
            (".//div[@class=\"cm-notification-content notification-content alert-error\"]");

    public String AssertUserExists() {
        System.out.println(getText(AlarmMessage));
        return getText(AlarmMessage);
    }

    private By CartItemsCount = By.xpath(".//a[@class=\"ty-cart-content__product-title\"]");
    private By ViewCartButton = By.xpath
            (".//a[@href=\"https://egyptlaptop.com/cart\" and contains(text(), \"View cart\")]");

    public void ViewCartItem() {
        clickElement(CartIcon);
        clickElement(ViewCartButton);
    }

    public int CartCountPage() {
        return driver.findElements(CartItemsCount).size();
    }

    private By ProceedToChechoutButton = By.xpath
            (".//a[@href='https://egyptlaptop.com/checkout']//bdi[contains(text(), 'Proceed to checkout')]");

    public void ProceedToCheckout() {
        WaitTillVisibleAndClick(ProceedToChechoutButton);
    }

    private By LoginButton =
            By.xpath(".//div[@class='ty-account-info__buttons buttons-container']/a[contains(text(), 'Sign in')]");

    public void PressProfileIcon() {
        WaitTillVisibleAndClick(ProfileIcon);
    }

    public SignInPage PressLoginButton() throws InterruptedException {
        WaitTillVisibleAndClick(LoginButton);
        return new SignInPage(driver);
    }

    public String AssertLoginSuccessful() throws InterruptedException {
        By UserName = By.xpath("//li[contains(text(), \"a1hmed Mohamed\")]");
        Thread.sleep(4000);
        WaitTillVisibleAndClick(ProfileIcon);
        return getText(UserName);

    }
}


package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    // un registered user select items add them to cart and checkout

    private By AddToCartButton = By.xpath("//button[.//bdi[contains(text(), 'Add to cart')]]");
    private By CartIcon = By.xpath(".//div[@class=\"ut2-top-cart-content \"]");
    private By AssertCart = By.xpath(".//i/span[@class=\"ty-minicart-count\"]");

    private By CheckoutButton = By.xpath(".//a[@href=\"https://egyptlaptop.com/checkout\"]");

    public void PressAddCartButton() {
        WaitUntilElementBeClickable(AddToCartButton);
        clickElement(AddToCartButton);
    }

    public int AssertCartIconCount() {
        WaitUntilVisibleElement(AssertCart);
        int CartCount = Integer.parseInt(driver.findElement(AssertCart).getText());
        return CartCount;
    }

    public CheckOut PressCheckOutButton() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(CartIcon)));
        clickElement(CartIcon);
        WaitTillVisibleAndClick(CheckoutButton);
        return new CheckOut(driver);
    }

}

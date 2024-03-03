import Base.BaseTest;
import Pages.CheckOut;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompletePurchase extends BaseTest {
    public ProductPage productPage;
    public CheckOut checkOut;

    // Unregistered user completed purchase process
// user search for keyword and select item to add to cart
// >> show his cart item to select proceed to checkout,
// completed checkOut process
    @Test(priority = 1)
    public void CompletePlaceOrder() throws InterruptedException {

        homePage.EnterKeyWord("laptop");
        homePage.PressEnter();
        productPage = homePage.PressSelectedItem();
        productPage.PressAddCartButton();
        Assert.assertEquals(productPage.AssertCartIconCount(), 1);
        checkOut = productPage.PressCheckOutButton();
        homePage.ViewCartItem();
        soft.assertEquals(homePage.CartCountPage(), productPage.AssertCartIconCount());
        homePage.ProceedToCheckout();
        checkOut.EnterCustomerData("AhmedMohamed", "0123456789");
        checkOut.EnterDeliveryDetails("gaza");
        checkOut.CheckTermsAndConditions();
        checkOut.PressPlaceOrderButton();
        soft.assertEquals(checkOut.GetConfirmationMessage(),
                "Congratulations! Your order has been successfully placed.\n",
                "User failed to completed purchase");

    }
}

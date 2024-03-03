import Base.BaseTest;
import Pages.CheckOut;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTests extends BaseTest {
    public ProductPage productPage;
    public CheckOut checkOut;

    @Test()
    public void CreateAccount() {
        homePage.PressRegisterButton();
        homePage.EnterAccountDetails("a1hmed", "Mohamed", "01009923040",
                "a12hmed@gmail.com", "123456", "123456");
        soft.assertEquals(homePage.AssertUserCreated(), "https://egyptlaptop.com/profiles-update",
                "new user didn't created");
        soft.assertTrue(homePage.AssertUserExists().
                        contains("The username or email you have chosen already exists. Please try another one.\n"),
                "User Created successfully");
        soft.assertAll();


    }
}
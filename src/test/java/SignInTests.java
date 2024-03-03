import Base.BaseTest;
import Pages.SignInPage;
import org.testng.annotations.Test;

public class SignInTests extends BaseTest {

    public SignInPage sp;

    @Test
    public void testSignIn() throws InterruptedException {
        homePage.PressProfileIcon();
        sp = homePage.PressLoginButton();
        sp.setEmailField("a11hmed@gmail.com");
        sp.setPasswordField("123456");
        sp.PressLoginButton();
        soft.assertEquals(homePage.AssertLoginSuccessful(), "a1hmed Mohamed");
    }
}

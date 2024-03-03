package Base;

import Pages.HomePage;
import Pages.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    public static final String BASE_URL = "https://egyptlaptop.com/?match=all&subcats=Y&pcode_from_q=Y&pshort=Y&pfull=Y&pname=Y&pkeywords=Y&search_performed=Y&q=cable+hdmi&dispatch=products.search";
    public WebDriver driver;
    protected SoftAssert soft;
    public HomePage homePage;

    @BeforeTest
    public void setUp() throws InterruptedException {
        // System.setProperty("webdriver.edge.driver", "resources/msedgedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.edgedriver().setup();

        driver = new EdgeDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        soft = new SoftAssert();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

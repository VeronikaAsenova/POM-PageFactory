package selenium;

import com.mentormate.pages.HomePage;
import com.mentormate.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("--no sandbox");
        options.addArguments("--window-size=1440x900");

        WebDriverManager.chromedriver().browserVersion("103").setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver);

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testLoginPage() {

        loginPage.login("roni","roni95");

        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isLogoutLinkDisplayed());

    }
}

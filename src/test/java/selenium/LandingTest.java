package selenium;

import com.mentormate.pages.LandingPage;
import com.mentormate.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LandingTest {
    public WebDriver driver;
    LandingPage landingPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no sandbox");
        options.addArguments("--window-size=1440x900");

        WebDriverManager.chromedriver().browserVersion("103").setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        landingPage = new LandingPage(driver);

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testLandingPage() {

        Assert.assertTrue(landingPage.isLoginLinkDisplayed());

//        List<WebElement> listPost = driver.findElements(By.xpath("//div[@class='row post-list-container']//app-post-detail"));

        Assert.assertEquals(landingPage.listPostGetSize(), 3);

        landingPage.loginBtnClick();

        loginPage = new LoginPage(driver);

        Assert.assertTrue(loginPage.isSignInTxtDisplayed());
    }
}

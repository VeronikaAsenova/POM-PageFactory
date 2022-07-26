package selenium;

import com.mentormate.common.Screenshot;
import com.mentormate.pages.LandingPage;
import com.mentormate.pages.LoginPage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LandingTest extends BaseTest {
    //    public WebDriver driver;
    LandingPage landingPage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        landingPage = new LandingPage(driver);
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

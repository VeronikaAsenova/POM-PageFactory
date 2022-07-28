package selenium;

import com.mentormate.common.RetryAnalyzer;
import com.mentormate.common.Screenshot;
import com.mentormate.pages.HomePage;
import com.mentormate.pages.LoginPage;
import com.mentormate.pages.NewPostPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
Testing New Post uploading and create
*/

public class NewPostTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;

    NewPostPage newPostPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            Screenshot.capture(driver, "src/screenshots", result.getName());
        }
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testLoginPage() {

        loginPage.login("roni", "roni95");

        homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isLogoutLinkDisplayed());

        homePage.newLinkPostClick();

        newPostPage = new NewPostPage(driver);

        newPostPage.uploadFile("/Users/veronika/Downloads/02-Blog-Healthy-Food-L.jpg");

        newPostPage.switchTypeOfPost();

        newPostPage.createPostBtnClick();

        Assert.assertEquals(newPostPage.getAlertMsg(), "Post created!");
    }
}

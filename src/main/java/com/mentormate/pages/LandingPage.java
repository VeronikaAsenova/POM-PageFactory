package com.mentormate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LandingPage {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

//    By loginLinkBy = By.id("nav-link-login");
//    WebElement loginBtn;

    @FindBy(id = "nav-link-login")
    WebElement loginBtn;

    @FindBy(xpath = "//div[@class='row post-list-container']//app-post-detail")
    List<WebElement> listPost;

    public LandingPage(WebDriver driver) {
        this.driver = driver;

        //implicitWaits
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);

        driver.get("http://training.skillo-bg.com");
//        loginBtn = driver.findElement(loginLinkBy);
        PageFactory.initElements(driver, this);
    }

    //init web elements methods
    public void loginBtnClick() {
        loginBtn.click();
    }

    public int listPostGetSize() {
        return listPost.size();
    }

    //Verification methods
    public boolean isLoginLinkDisplayed() {
        return loginBtn.isDisplayed();
    }
}

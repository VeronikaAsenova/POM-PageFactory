package com.mentormate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

//    By signInTxtBy = By.xpath("//p[text()='Sign in']");
    @FindBy(xpath = "//p[text()='Sign in']")
    WebElement signInTxt;

//    By userNameBy = By.cssSelector("#defaultLoginFormUsername");
    @FindBy(css = "#defaultLoginFormUsername")
    WebElement userName;

//    By passwordBy = By.cssSelector("#defaultLoginFormPassword");
    @FindBy(css = "#defaultLoginFormPassword")
    WebElement password;

    By signInBtnBy = By.cssSelector("#sign-in-button");
    @FindBy(css = "#sign-in-button")
    WebElement signInBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;

        //implicitWaits
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);

        driver.get("http://training.skillo-bg.com/users/login");

//        signInTxt = driver.findElement(signInTxtBy);
//        userName = driver.findElement(userNameBy);
//        password = driver.findElement(passwordBy);
//        signInBtn = driver.findElement(signInBtnBy);

        //ако имаме 50 елемента трябва да инициализираме всеки един по отделно, но с PageFactory
        //е достатъчно само долния ред

        PageFactory.initElements(driver,this);

    }

    //init web elements methods

    public void fillUsername(String username) {
        userName.click();
        userName.clear();
        userName.sendKeys(username);

    }

    public void fillPassword(String pass) {
        password.click();
        password.clear();
        password.sendKeys(pass);

    }

    public void signInBtnClick() {
        signInBtn.click();
    }

    public void login(String username, String pass){
        fillUsername(username);
        fillPassword(pass);
        signInBtnClick();
    }


    //Verification methods
    public boolean isSignInTxtDisplayed() {
        return signInTxt.isDisplayed();
    }
}

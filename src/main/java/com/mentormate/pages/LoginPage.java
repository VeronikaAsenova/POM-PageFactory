package com.mentormate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    final static String SIGN_IN_TXT_BY = "//p[text()='Sign in']";
    @FindBy(xpath = SIGN_IN_TXT_BY)
    WebElement signInTxt;

    @FindBy(css = "#defaultLoginFormUsername")
    WebElement userName;

    @FindBy(css = "#defaultLoginFormPassword")
    WebElement password;

    @FindBy(css = "#sign-in-button")
    WebElement signInBtn;

    public LoginPage(WebDriver driver) {
        super(driver);

        driver.get("http://training.skillo-bg.com/users/login");

//        signInTxt = driver.findElement(signInTxtBy);
//        userName = driver.findElement(userNameBy);
//        password = driver.findElement(passwordBy);
//        signInBtn = driver.findElement(signInBtnBy);

        //ако имаме 50 елемента трябва да инициализираме всеки един по отделно, но с PageFactory е достатъчно само долния ред
        PageFactory.initElements(driver, this);
    }

    //init web elements methods

    public void fillUsername(String username) {
        click(By.xpath(SIGN_IN_TXT_BY));
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

    public void login(String username, String pass) {
        fillUsername(username);
        fillPassword(pass);
        signInBtnClick();
    }


    //Verification methods
    public boolean isSignInTxtDisplayed() {
        return signInTxt.isDisplayed();
    }
}

package com.mentormate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewPostPage extends BasePage {
    @FindBy(css = ".fas.fa-sign-out-alt.fa-lg")
    WebElement logoutLink;

    @FindBy(css = ".file.ng-untouched.ng-pristine.ng-invalid")
    WebElement browseFileInput;
    @FindBy(css = "#create-post")
    WebElement createPostBtn;

    @FindBy(css = "label[for]")
    WebElement switchType;

    @FindBy(xpath = "//div[text()='Post created!']")
    WebElement alertMsg;

    @FindBy(xpath = "//div[text()='Successful login!']")
    WebElement alertMsgSuccessfulLogin;


    public NewPostPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    //init web elements methods
    public void browseBtnClick() {
        browseFileInput.click();
    }

    public void uploadFile(String filePath) {
        browseFileInput.sendKeys(filePath);
    }

    public void switchTypeOfPost() {
        switchType.click();
    }

    public void createPostBtnClick() {
        createPostBtn.click();
    }



    public String getAlertMsg() {
        wait.until(ExpectedConditions.invisibilityOf(alertMsgSuccessfulLogin));
        return alertMsg.getText();
    }

    //Verification methods
    public boolean isLogoutLinkDisplayed() {
        return logoutLink.isDisplayed();
    }
}

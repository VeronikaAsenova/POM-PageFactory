package com.mentormate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPostPage extends BasePage {
    @FindBy(css = ".fas.fa-sign-out-alt.fa-lg")
    WebElement logoutLink;

    @FindBy(css = ".file.ng-untouched.ng-pristine.ng-invalid")
    WebElement browseFileInput;
    @FindBy(css = "#create-post")
    WebElement createPostBtn;

    @FindBy(css = "label[for]")
    WebElement switchType;

    @FindBy(xpath = "//div[@id='toast-container']")
    WebElement alertMsg;

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

    public void createPostBtnClick() {
        createPostBtn.click();
    }

    public void switchTypeOfPost() {
        switchType.click();
    }

    public String getAlertMsg() {
        return alertMsg.getText();
    }

    //Verification methods
    public boolean isLogoutLinkDisplayed() {
        return logoutLink.isDisplayed();
    }
}

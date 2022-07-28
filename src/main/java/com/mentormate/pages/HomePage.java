package com.mentormate.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    @FindBy(css = ".fas.fa-sign-out-alt.fa-lg")
    WebElement logoutLink;

    @FindBy(css = "a#nav-link-new-post")
    WebElement newPostLink;



    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    //init web elements methods
    public void newLinkPostClick() {
        newPostLink.click();
    }

    //Verification methods
    public boolean isLogoutLinkDisplayed() {
        return logoutLink.isDisplayed();
    }
}

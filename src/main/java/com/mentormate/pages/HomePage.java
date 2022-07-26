package com.mentormate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
    @FindBy(css = ".fas.fa-sign-out-alt.fa-lg")
    WebElement logoutLink;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    //init web elements methods


    //Verification methods
    public boolean isLogoutLinkDisplayed() {
        return logoutLink.isDisplayed();
    }
}

package com.mentormate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;


    By logoutLinkBy = By.cssSelector(".fas.fa-sign-out-alt.fa-lg");
    WebElement logoutLink;


    public HomePage(WebDriver driver) {
        this.driver = driver;

        //implicitWaits
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);

        logoutLink = driver.findElement(logoutLinkBy);

    }

    //init web elements methods


    //Verification methods
    public boolean isLogoutLinkDisplayed() {
        return logoutLink.isDisplayed();
    }
}

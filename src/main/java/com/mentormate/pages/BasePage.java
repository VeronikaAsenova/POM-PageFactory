package com.mentormate.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;
    public FluentWait fluentWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        //implicitWaits
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        //fluent wait
        fluentWait = new FluentWait<>(driver);
        fluentWait.pollingEvery(Duration.ofMillis(250));
        fluentWait.withTimeout(Duration.ofSeconds(15));
        fluentWait.ignoring(NoSuchElementException.class);

        //explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        actions = new Actions(driver);
    }
    //Wrapper methods

    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    //Click Method
    public void click (By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

}

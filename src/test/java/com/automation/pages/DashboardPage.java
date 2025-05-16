package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;
    private By welcomeBanner = By.cssSelector(".welcome-banner");
    private By logoutButton  = By.id("logoutBtn");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoaded() {
        return driver.findElement(welcomeBanner).isDisplayed();
    }

    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }
}

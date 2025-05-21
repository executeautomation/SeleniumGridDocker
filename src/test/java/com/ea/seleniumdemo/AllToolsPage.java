package com.ea.seleniumdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllToolsPage {

    private WebDriver driver;

    @FindBy(id = "products-page")
    private WebElement productsPageIdentifier;

    public AllToolsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isProductListDisplayed() {
        return productsPageIdentifier.isDisplayed();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}

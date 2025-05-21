package com.ea.seleniumdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://www.jetbrains.com/
public class MainPage {
    @FindBy(css = "a.wt-button_mode_primary")
    private WebElement seeAllToolsButton;

    @FindBy(xpath = "//div[@data-test='main-menu-item' and @data-test-marker = 'Developer Tools']")
    private WebElement toolsMenu;

    @FindBy(css = "[data-test='site-header-search-action']")
    private WebElement searchButton;

    private Actions actions;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.actions = new Actions(driver);
    }

    public void clickSeeAllToolsButton() {
        seeAllToolsButton.click();
    }

    public void hoverOverToolsMenu() {
        actions.moveToElement(toolsMenu).perform();
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    // WebElements for the search input field that appears after clicking the main search icon
    @FindBy(css = "[data-test='search-input']")
    private WebElement initialSearchInput;

    @FindBy(css = "button[data-test='full-search-button']")
    private WebElement submitSearchFormButton;

    public void enterInitialSearchText(String text) {
        initialSearchInput.sendKeys(text);
    }

    public void clickSubmitInitialSearch() {
        submitSearchFormButton.click();
    }
}

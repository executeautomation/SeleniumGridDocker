package com.ea.seleniumdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

    private WebDriver driver;

    @FindBy(css = "input[data-test='search-input']")
    private WebElement searchFieldOnResultsPage;

    // The subtask description mentions `submitButtonOnResultsPage` with selector `button[data-test='full-search-button']`
    // However, on a typical search results page, there isn't usually another "submit" button next to the search field.
    // The search is often re-triggered by typing and pressing Enter, or by a search icon button.
    // For now, I'll include it as requested, but this might need adjustment if the actual page functionality is different.
    // It's possible this selector is the same as the one on the initial search form, which would be an issue.
    // Let's assume for now it's a distinct element on the results page.
    @FindBy(css = "button[data-test='full-search-button']")
    private WebElement submitButtonOnResultsPage; // This selector might be problematic if it's not unique to the results page

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getSearchFieldValue() {
        return searchFieldOnResultsPage.getAttribute("value");
    }

    // This method might be for modifying the search on the results page
    public void enterSearchText(String text) {
        searchFieldOnResultsPage.clear(); // Good practice to clear before sending keys
        searchFieldOnResultsPage.sendKeys(text);
    }

    // This method would click the search button on the results page, if one exists with this selector
    public void clickSubmitSearch() {
        submitButtonOnResultsPage.click();
    }
}

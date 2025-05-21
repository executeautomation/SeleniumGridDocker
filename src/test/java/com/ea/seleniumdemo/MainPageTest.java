package com.ea.seleniumdemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

import static org.assertj.core.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class MainPageTest extends Base{

    @Test
    public void search() {
        mainPage.clickSearchButton();
        mainPage.enterInitialSearchText("Selenium");
        mainPage.clickSubmitInitialSearch();

        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        assertThat(searchResultsPage.getSearchFieldValue()).isEqualTo("Selenium");
    }
}

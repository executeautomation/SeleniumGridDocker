package com.ea.seleniumdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class Base {

    private static Properties properties;

    static {
        properties = new Properties();
        String configFileName = "config.properties";
        try (InputStream inputStream = Base.class.getClassLoader().getResourceAsStream(configFileName)) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("Property file '" + configFileName + "' not found in the classpath");
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot load properties file: " + configFileName, e);
        }
    }

    public WebDriver driver;
    public MainPage mainPage;

    @BeforeTest
    public void InitializeBrowser() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-dev-shm-usage");
        try {
            driver = new RemoteWebDriver(new URL(properties.getProperty("selenium.grid.url"))
                    ,chromeOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Malformed URL for Selenium Grid: " + properties.getProperty("selenium.grid.url"), e);
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(properties.getProperty("app.url"));

        mainPage = new MainPage(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

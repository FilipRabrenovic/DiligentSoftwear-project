package com.esagaming.qa.core;

import com.esagaming.qa.utils.Paths;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverWrapper {

    private String driverType = "chrome";

    private WebDriver createDriver(String driverType) {
        switch (driverType) {
            case "chrome":
                return createChromeDriver();
            case "firefox":
                return createFirefoxDriver();
            case "safari":
            case "ie":
                default:
                return null;
        }
    }

    private WebDriver createChromeDriver() {
        System.setProperty("webdriver.chrome.driver", Paths.CHROME_DRIVER_PATH);
        return new ChromeDriver();
    }

    private WebDriver createFirefoxDriver(){
        System.setProperty("webdriver.gecko.driver", Paths.MOZZILA_DRIVER_PATH);
        return new FirefoxDriver();
    }

    public WebDriver getDriver() {
        return createDriver(driverType);
    }
}

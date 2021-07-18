package com.esagaming.qa.testcases;

import com.esagaming.qa.core.DriverWrapper;
import com.esagaming.qa.pages.HomePage;
import com.esagaming.qa.utils.ProjectURLs;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FilteringAndAddingToCart {

    WebDriver driver;
    HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        driver = new DriverWrapper().getDriver();
        driver.manage().window().maximize();
        driver.get(ProjectURLs.BASE_URL);
        homePage = new HomePage(driver);
    }

    @Test
    public void test() {

    }

}

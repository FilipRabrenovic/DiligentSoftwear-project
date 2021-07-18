package com.esagaming.qa.testcases;

import UserVariable.Variables;
import com.esagaming.qa.core.DriverWrapper;
import com.esagaming.qa.pages.HomePage;
import com.esagaming.qa.utils.ProjectURLs;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.DriverManager;

public class LogInWithValidCredentials {

    WebDriver driver;
    HomePage homePage;

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        driver = new DriverWrapper().getDriver();
        driver.manage().window().maximize();
        driver.get(ProjectURLs.BASE_URL);
        homePage = new HomePage(driver);
    }

    @Test(description = "Log in with valid credentials")
    public void logInWithValidCredentials(){
        homePage.clickOnSingInButton()
                .enterEmail(Variables.EMAIL_LOG_IN)
                .clickCountinueLogInButton()
                .enterPassword(Variables.PASSWORD_LOG_IN)
                .clickOnSignInButton();
        driver.navigate().refresh();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){driver.quit();}
}

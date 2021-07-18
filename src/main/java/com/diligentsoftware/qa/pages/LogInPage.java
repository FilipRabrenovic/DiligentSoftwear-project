package com.diligentsoftware.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LogInPage extends BasePage {


    @FindBy(how = How.XPATH, using = "//*[@id=\"join_neu_password_field\"]")
    private WebElement txt_password;

    @FindBy(how = How.XPATH, using = "//button[@value='sign-in']")
    private WebElement btn_SignIn;

    protected LogInPage(WebDriver driver) { super(driver); }

    public LogInPage enterPassword(String password){
        enterText(txt_password, password);
        return new LogInPage(driver);
    }

    public HomePage clickOnSignInButton(){
        clickOnElement(btn_SignIn);
        return new HomePage(driver);
    }
}

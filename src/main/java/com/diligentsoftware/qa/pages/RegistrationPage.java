package com.diligentsoftware.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage extends BasePage{


    @FindBy(how = How.XPATH, using = "//button[@name='submit_attempt']")
    private WebElement btn_continue;

    @FindBy(how = How.XPATH, using = "//*[@id=\"join_neu_email_field\"]")
    private WebElement txt_email;

    @FindBy(how = How.XPATH, using = "//*[@id=\"join_neu_first_name_field\"]")
    private WebElement txt_FirstName;

    @FindBy(how = How.XPATH, using = "//*[@id=\"join_neu_password_field\"]")
    private WebElement txt_password;

    @FindBy(how = How.XPATH, using = "//button[@value='register']")
    private WebElement btn_register;

    public RegistrationPage(WebDriver driver) { super(driver); }

    public RegistrationPage enterEmail(String email){
        enterText(txt_email, email);
        return new RegistrationPage(driver);
    }

    public RegistrationPage clickCountinueRegistration(){
        clickOnElement(btn_continue);
        return new RegistrationPage(driver);
    }

    public RegistrationPage enterFirstName(String userFirstName){
        enterText(txt_FirstName, userFirstName);
        return new RegistrationPage(driver);
    }

    public RegistrationPage enterPassword(String password){
        enterText(txt_password,password);
        return new RegistrationPage(driver);
    }
    public HomePage clickRegisterButton(){
        clickOnElement(btn_register);
        return new HomePage(driver);
    }

    public LogInPage clickCountinueLogInButton(){
        clickOnElement(btn_continue);
        return new LogInPage(driver);
    }
}

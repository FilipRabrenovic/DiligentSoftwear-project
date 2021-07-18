package com.esagaming.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {

    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Sign in')]")
    private WebElement bnt_sign_in;

    @FindBy(how = How.XPATH, using = "//*[@id=\"global-enhancements-search-query\"]")
    private WebElement txt_search;

    @FindBy(how = How.XPATH, using = "//*[@id='gnav-search']/div/div[1]/button")
    private WebElement btn_search;

    public HomePage(WebDriver driver) { super(driver); }

    public RegistrationPage clickOnSingInButton(){
        clickOnElement(bnt_sign_in);
        return new RegistrationPage(driver);
    }
    public HomePage enterTextInInputField(String searchText){
        enterText(txt_search, searchText);
        return new HomePage(driver);
    }
    public SearchPage clickOnSearchButton(){
        clickOnElement(btn_search);
        return new SearchPage(driver);
    }

}

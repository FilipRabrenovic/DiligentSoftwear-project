package com.diligentsoftware.qa.pages;

import com.diligentsoftware.qa.utils.TimeUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FilterPage extends BasePage{

    @FindBy(how = How.XPATH, using = "//label[@for=\"special-offers-free-shipping\"]")
    private WebElement cbox_freeshipping;

    @FindBy(how = How.XPATH, using = "//label[@for=\"price-input-2\"]")
    private WebElement rbtn_price;

    @FindBy(how = How.XPATH, using = "//select[@name='ship_to']")
    private WebElement drb_shipto;

    @FindBy(how = How.XPATH, using = "//option[@value='HR' and @data-path='Croatia']")
    private WebElement select_country;

    @FindBy(how = How.XPATH, using = "//button[@aria-label='Apply']")
    private WebElement btn_apply;


    public FilterPage clickcheckboxFreeShipping(){
        clickOnElement(cbox_freeshipping);
        return new FilterPage(driver);
    }

    public FilterPage clickradiobuttonPrice(){
        clickOnElement(rbtn_price);
        return new FilterPage(driver);
    }

    public FilterPage clickdropboxShipTO(){
        clickOnElement(drb_shipto);
        waitForElement(drb_shipto);
        return new FilterPage(driver);
    }

    public FilterPage selectchangeCountry(){
        clickOnElement(select_country);
        return new FilterPage(driver);
    }

    public SearchPage clickonApply(){
        clickOnElement(btn_apply);
        return new SearchPage(driver);
    }






    protected FilterPage(WebDriver driver) {
        super(driver);
    }
}

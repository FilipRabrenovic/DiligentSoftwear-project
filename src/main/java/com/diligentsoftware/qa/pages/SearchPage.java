package com.diligentsoftware.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchPage extends BasePage {

    @FindBy(how = How.ID, using = "search-filter-button")
    private WebElement btn_filter;

    @FindBy(how = How.XPATH, using = "//a[@data-position-num='1']")
    private WebElement btn_addItem;

    public FilterPage clickOnFilterButton(){
        clickOnElement(btn_filter);
        return new FilterPage(driver);
    }

    public ProductPage openItem(){
        clickOnElement(btn_addItem);
        return new ProductPage(driver);
    }

    protected SearchPage(WebDriver driver) { super(driver); }
}

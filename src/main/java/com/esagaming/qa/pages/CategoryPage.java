package com.esagaming.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CategoryPage extends BasePage{

    @FindBy(how = How.XPATH, using = "//*[@id=\"catnav-primary-link-10855\"]")
    private WebElement span_catagory_first;

    @FindBy(how = How.XPATH, using = "//*[@id=\"catnav-l4-10859\"]")
    private WebElement btn_headbands;

    protected CategoryPage(WebDriver driver) { super(driver); }
}

package com.diligentsoftware.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class ProductPage extends BasePage{

    @FindBy(how = How.XPATH, using = "//button//div[contains(text(), 'Add to cart')]")
    private WebElement btn_addtocart;

    public CartPage addtoCart(){
        clickOnElement(btn_addtocart);
        return new CartPage(driver);
    }





    protected ProductPage(WebDriver driver) {
        super(driver);
    }
}

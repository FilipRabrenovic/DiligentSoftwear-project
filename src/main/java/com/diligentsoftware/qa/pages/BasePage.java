package com.diligentsoftware.qa.pages;

import com.diligentsoftware.qa.utils.TimeUtils;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;

public abstract class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final Logger log = LogManager.getLogger(this.getClass());
    protected Actions builder;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 30);
    }

    protected WebElement waitForElement(WebElement element) {
        try {
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOf(element),
                    ExpectedConditions.elementToBeClickable(element)
            ));
            return element;
        } catch (StaleElementReferenceException e) {
            log.debug("[WARNING] Stale element reference is caught while waiting for element: " + element + ". Waiting again...");
            TimeUtils.forceWait(1);
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOf(element),
                    ExpectedConditions.elementToBeClickable(element)
            ));
            return element;
        }
    }

    protected WebElement waitForElement(By by) {
        try {
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOfElementLocated(by),
                    ExpectedConditions.elementToBeClickable(by)
            ));
            return driver.findElement(by);
        } catch (StaleElementReferenceException e) {
            log.debug("[WARNING] Stale element reference is caught while waiting for element: " + by.toString() + ". Waiting again...");
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOfElementLocated(by),
                    ExpectedConditions.elementToBeClickable(by)
            ));
            return driver.findElement(by);
        }
    }

    protected WebElement waitForElement(String locator) {
        try {
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)),
                    ExpectedConditions.elementToBeClickable(By.xpath(locator))
            ));
            return driver.findElement(By.xpath(locator));
        } catch (StaleElementReferenceException e) {
            log.debug("[WARNING] Stale element reference is caught while waiting for element: " + locator + ". Waiting again...");
            wait.until(ExpectedConditions.and(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)),
                    ExpectedConditions.elementToBeClickable(By.xpath(locator))
            ));
            return driver.findElement(By.xpath(locator));
        }
    }

    protected WebElement waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    protected WebElement clickOnElement(WebElement element) {
        try {
            waitForElement(element);
            element.click();
        } catch (Exception e) {
            Assert.fail("Couldn't click on element " + element.toString());
        }
        return element;
    }


    protected WebElement clickOnElement(By by) {
        WebElement element = waitForElement(by);
        element.click();
        return element;
    }

    protected WebElement enterText(WebElement element, String text) {
        waitForElement(element);
        element.clear();
        element.sendKeys(text);
        return element;
    }

    protected WebElement enterText(By by, String text) {
        WebElement element = waitForElement(by);
        element.clear();
        element.sendKeys(text);
        return element;
    }

    protected String getTextFromElement(WebElement element) {
        waitForElement(element);
        return element.getText();
    }

    protected String getTextFromElement(By by) {
        WebElement element = waitForElement(by);
        return element.getText();
    }

    protected void switchToIframe(WebElement iframe) {
        waitForElement(iframe);
        driver.switchTo().frame(iframe);
    }

    protected void switchToDefaultFrame() {
        driver.switchTo().defaultContent();
    }

    protected String getAttributeFromAnElement(WebElement element, String attributeName) {
        waitForElement(element);
        return element.getAttribute(attributeName);
    }

    protected void dragAndDropElement(WebElement selectedElement, WebElement destinationElement) {
        builder = new Actions(driver);
        builder.dragAndDrop(selectedElement, destinationElement).build().perform();
    }

    protected void dragAndDropByOffset(WebElement selectElement, int offsetX, int offsetY) {
        builder = new Actions(driver);
        builder.clickAndHold(selectElement).
                moveByOffset(offsetX, offsetY)
                .release().build().perform();
    }

    protected WebElement hoverOverAndClick(WebElement element) {
        waitForElement(element);
        builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
        builder.click(element).build().perform();
        return element;
    }

    protected WebElement hoverOverAndClickViaJavascript(WebElement element) {
        waitForElement(element);
        builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
        return element;
    }

    protected void createSS() {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String fileName = "ss" + Math.random() + ".png";
            FileUtils.copyFile(scrFile, new File("./screenshots/" + fileName));
        } catch (Exception e) {
            log.error("COULDNT CREATE SCREENSHOT");
        }
    }

    protected WebElement setAttribute(WebElement element, String attributeName, String attributeValue) {
        waitForElement(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "')", element);
        return element;
    }
}

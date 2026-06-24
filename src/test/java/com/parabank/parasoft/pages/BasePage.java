package com.parabank.parasoft.pages;

import com.aventstack.extentreports.Status;
import com.parabank.parasoft.report.ReportTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasePage extends Page {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getElement(By selector) {
        try {
            addInfo("Finding element: " + selector.toString());
            return driver.findElement(selector);
        } catch (Exception e) {
            addFailInfo("Element not found: " + selector.toString());
            throw new RuntimeException("Element not found: " + selector.toString());
        }
    }

    @Override
    public List<WebElement> getElements(By selector) {
        try {
            addInfo("Finding elements: " + selector.toString());;
            return driver.findElements(selector);
        } catch (Exception e) {
            addFailInfo("Elements not found: " + selector.toString());
            throw new RuntimeException("Elements not found: " + selector.toString());
        }
    }

    @Override
    public void clickElement(By selector) {
        try {
            addInfo("Clicking element: " + selector.toString());
            getElement(selector).click();
           addInfo("Clicked element: " + selector.toString());
        } catch (Exception e) {
            addFailInfo("Failed to click element: " + selector.toString());
            throw new RuntimeException("Element not clickable: " + selector.toString());
        }

    }

    @Override
    public void setWait(By locator) {
        addInfo("Waiting for element: " + locator.toString());
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        addInfo("Element is present: " + locator.toString());
    }

    @Override
    public String getElementText(By selector) {
        addInfo("Getting text from element: " + selector.toString());
        return getElement(selector).getText().trim();
    }

    @Override
    public void fillText(By selector, String text) {
        addInfo("Filling text into element: " + selector.toString());
        getElement(selector).sendKeys(text);
        addInfo("Filled text into element: " + selector.toString());
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    public Select getSelect(By selector) {
        addInfo("Getting select element: " + selector.toString());
        return new Select(getElement(selector));
    }

    public void addInfo(String message) {
        if (ReportTestManager.getTest() != null) {
            ReportTestManager.getTest().log(Status.INFO, message);
        }
    }

    public void addFailInfo(String message) {
        if (ReportTestManager.getTest() != null) {
            ReportTestManager.getTest().log(Status.FAIL, message);
        }
    }
}

package com.parabank.parasoft.pages;

import com.parabank.parasoft.util.ParaBankUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerLoginPage extends BasePage {
    public CustomerLoginPage(WebDriver driver) {
        super(driver);
    }

    public CustomerLoginPage fillUserName(String username) {
        fillText(By.cssSelector("input[name='username']"), username);
        return this;
    }

    public CustomerLoginPage fillPassword(String password) {
        fillText(By.xpath("//input[@name='password']"), password);
        return this;
    }

    public OverviewPage clickLoginBtnSuccessfully() {
        clickElement(By.cssSelector("input[value='Log In']"));
        return navigateToPage(OverviewPage.class);
    }

    public CustomerLoginPage clickLoginBtnFailure() {
        clickElement(By.cssSelector("input[value='Log In']"));
        return this;
    }

    public String getErrorMessage() {
        return getElementText(By.cssSelector("p[class='error']")).trim();
    }

    public RegisterPage clickRegisterLink() {
        clickElement(By.linkText("Register"));
        return navigateToPage(RegisterPage.class);
    }
}

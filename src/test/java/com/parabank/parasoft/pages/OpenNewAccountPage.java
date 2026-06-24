package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OpenNewAccountPage extends BasePage {
    public OpenNewAccountPage(WebDriver driver) {
        super(driver);
    }

    public OpenNewAccountPage selectAccountType(int index) {
        getSelect(By.xpath("//select[@id='type']")).selectByIndex(index);
        return this;
    }

    public OpenNewAccountPage selectAccountType(String value) {
        getSelect(By.xpath("//select[@id='type']")).selectByValue(value);
        return this;
    }

    public AccountOpenedPage clickOpenNewAccountBtn() {
        clickElement(By.xpath("//input[@value='Open New Account']"));
        return navigateToPage(AccountOpenedPage.class);
    }


}

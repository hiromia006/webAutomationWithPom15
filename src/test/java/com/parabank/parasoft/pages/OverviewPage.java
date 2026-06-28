package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends BasePage {
    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasLogoutLink() {
        return getElements(By.cssSelector("a[href='logout.htm']")).size() > 0;
    }

    public OpenNewAccountPage clickOpenNewAccountLink() {
        clickElement(By.cssSelector("a[href='openaccount.htm']"));
        return navigateToPage(OpenNewAccountPage.class);
    }

    public RequestLoanPage clickRequestLoanLink() {
        clickElement(By.cssSelector("a[href='requestloan.htm']"));
        return navigateToPage(RequestLoanPage.class);
    }
}

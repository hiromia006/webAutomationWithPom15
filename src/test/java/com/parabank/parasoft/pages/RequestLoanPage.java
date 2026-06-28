package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RequestLoanPage extends BasePage {
    public RequestLoanPage(WebDriver driver) {
        super(driver);
    }

    public RequestLoanPage fillLoanAmount(int amount) {
        fillText(By.id("amount"), String.valueOf(amount));
        return this;
    }

    public RequestLoanPage fillDownPayment(int downPayment) {
        fillText(By.id("downPayment"), String.valueOf(downPayment));
        return this;
    }

    public LoanRequestProcessedPage clickApplyNowButton() {
        clickElement(By.cssSelector("input[value='Apply Now']"));
        return navigateToPage(LoanRequestProcessedPage.class);
    }


}

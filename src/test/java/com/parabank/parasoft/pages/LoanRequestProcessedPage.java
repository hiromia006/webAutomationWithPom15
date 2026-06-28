package com.parabank.parasoft.pages;

import com.parabank.parasoft.util.ParaBankUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoanRequestProcessedPage extends BasePage{
    public LoanRequestProcessedPage(WebDriver driver) {
        super(driver);
    }

    public boolean haseApprovedStatus(){
        ParaBankUtil.waitForDomStable();
        return getElementText(By.id("loanStatus")).contains("Approved");
    }
}

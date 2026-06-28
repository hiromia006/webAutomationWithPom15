package com.parabank.parasoft.test;

import com.parabank.parasoft.pages.CustomerLoginPage;
import com.parabank.parasoft.pages.LoanRequestProcessedPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RequestLoanTest extends BaseTest{
    @Test
    public void requestLoanShouldSucceed(){
        LoanRequestProcessedPage page= pg.navigateToPage(CustomerLoginPage.class)
                .fillUserName(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtnSuccessfully()
                .clickRequestLoanLink()
                .fillLoanAmount(1000)
                .fillDownPayment(2)
                .clickApplyNowButton();
        Assert.assertTrue(page.haseApprovedStatus());
    }
}

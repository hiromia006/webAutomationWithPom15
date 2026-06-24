package com.parabank.parasoft.test;

import com.parabank.parasoft.pages.AccountOpenedPage;
import com.parabank.parasoft.pages.CustomerLoginPage;
import com.parabank.parasoft.pages.OpenNewAccountPage;
import com.parabank.parasoft.pages.OverviewPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenNewAccountTest extends BaseTest {
    @Test(enabled = false)
    public void validateOpenNewAccountV1() {
        CustomerLoginPage loginPage = pg.navigateToPage(CustomerLoginPage.class);

        OverviewPage overviewPage = loginPage
                .fillUserName(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtnSuccessfully();

        OpenNewAccountPage newAccountPage = overviewPage
                .clickOpenNewAccountLink()
                .selectAccountType(1);

        AccountOpenedPage openedPage = newAccountPage
                .clickOpenNewAccountBtn();

        Assert.assertTrue(openedPage.hasAccountId());

    }

    @Test
    public void validateOpenNewAccountV2() {
        AccountOpenedPage openedPage = pg.navigateToPage(CustomerLoginPage.class)
                .fillUserName(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtnSuccessfully()
                .clickOpenNewAccountLink()
                .selectAccountType(1)
                .clickOpenNewAccountBtn();

        Assert.assertTrue(openedPage.hasAccountId());

    }
}

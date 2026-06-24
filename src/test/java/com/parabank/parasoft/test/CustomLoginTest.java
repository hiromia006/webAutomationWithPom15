package com.parabank.parasoft.test;

import com.parabank.parasoft.pages.CustomerLoginPage;
import com.parabank.parasoft.pages.OverviewPage;
import com.parabank.parasoft.util.ParaBankUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomLoginTest extends BaseTest {
    @Test
    public void validateTittle() {
        CustomerLoginPage loginPage = pg.navigateToPage(CustomerLoginPage.class);
        Assert.assertEquals(loginPage.getPageTitle(), "ParaBank | Welcome | Online Banking");
    }

    @Test(enabled = false)
    public void validateLoginSuccessV1() {
        CustomerLoginPage loginPage = pg.navigateToPage(CustomerLoginPage.class);

        OverviewPage overviewPage = loginPage
                .fillUserName(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtnSuccessfully();
        Assert.assertTrue(overviewPage.hasLogoutLink());
    }

    @Test
    public void validateLoginSuccessV2() {
        OverviewPage overviewPage = pg.navigateToPage(CustomerLoginPage.class)
                .fillUserName(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtnSuccessfully();
        Assert.assertTrue(overviewPage.hasLogoutLink());
    }

    @Test
    public void validateLoginWithOutUsernameAndPassword() {
        CustomerLoginPage page = pg.navigateToPage(CustomerLoginPage.class)
                .clickLoginBtnFailure();
        Assert.assertEquals(page.getErrorMessage(), ParaBankUtil.ERROR, "");
    }

    @Test
    public void validateLoginWithOutPassword() {
        CustomerLoginPage page = pg.navigateToPage(CustomerLoginPage.class)
                .fillUserName("dadsads")
                .clickLoginBtnFailure();
        Assert.assertEquals(page.getErrorMessage(), ParaBankUtil.ERROR, "");
    }

    @Test
    public void validateLoginWithOutUsername() {
        CustomerLoginPage page = pg.navigateToPage(CustomerLoginPage.class)
                .fillPassword("demo")
                .clickLoginBtnFailure();
        Assert.assertEquals(page.getErrorMessage(), ParaBankUtil.ERROR, "");
    }
}

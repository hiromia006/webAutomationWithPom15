package com.parabank.parasoft.test;

import com.parabank.parasoft.pages.CustomerLoginPage;
import com.parabank.parasoft.pages.OverviewPage;
import com.parabank.parasoft.pages.RegisterPage;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
    @Test
    public void shouldDisplayLastNameRequiredValidationMessage() {
        RegisterPage registerPage = pg.navigateToPage(CustomerLoginPage.class)
                .fillUserName(LoremIpsum.getInstance().getName())
                .clickRegisterLink()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillAddress("123 Main St")
                .fillCity(LoremIpsum.getInstance().getCity())
                .fillState(LoremIpsum.getInstance().getStateAbbr())
                .fillZipCode(LoremIpsum.getInstance().getZipCode())
                .fillSSN("123-45-6789")
                .fillUsername(LoremIpsum.getInstance().getName())
                .fillPassword(LoremIpsum.getInstance().getTitle(1))
                .fillConfirmPassword(LoremIpsum.getInstance().getTitle(1))
                .clickRegisterBtnSFail();
        Assert.assertTrue(registerPage.hasRequiredFieldMessage(1));
    }

    @Test
    public void shouldDisplayAddressRequiredValidationMessage() {
        RegisterPage registerPage = pg.navigateToPage(CustomerLoginPage.class)
                .clickRegisterLink()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .fillCity(LoremIpsum.getInstance().getCity())
                .fillState(LoremIpsum.getInstance().getStateAbbr())
                .fillZipCode(LoremIpsum.getInstance().getZipCode())
                .fillSSN("123-45-6789")
                .fillUsername(LoremIpsum.getInstance().getName())
                .fillPassword(LoremIpsum.getInstance().getTitle(1))
                .fillConfirmPassword(LoremIpsum.getInstance().getTitle(1))
                .clickRegisterBtnSFail();
        Assert.assertTrue(registerPage.hasRequiredFieldMessage(1));
    }

    @Test
    public void shouldDisplayCityRequiredValidationMessage() {
        RegisterPage registerPage = pg.navigateToPage(CustomerLoginPage.class)
                .clickRegisterLink()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .fillAddress("123 Main St")
                .fillState(LoremIpsum.getInstance().getStateAbbr())
                .fillZipCode(LoremIpsum.getInstance().getZipCode())
                .fillSSN(LoremIpsum.getInstance().getPhone())
                .fillUsername(LoremIpsum.getInstance().getName())
                .fillPassword(LoremIpsum.getInstance().getTitle(1))
                .fillConfirmPassword(LoremIpsum.getInstance().getTitle(1))
                .clickRegisterBtnSFail();
        Assert.assertTrue(registerPage.hasRequiredFieldMessage(1));

    }

    @Test
    public void shouldDisplayStateRequiredValidationMessage() {
        RegisterPage registerPage = pg.navigateToPage(CustomerLoginPage.class)
                .clickRegisterLink()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .fillAddress("123 Main St")
                .fillCity(LoremIpsum.getInstance().getCity())
                .fillZipCode(LoremIpsum.getInstance().getZipCode())
                .fillSSN(LoremIpsum.getInstance().getPhone())
                .fillUsername(LoremIpsum.getInstance().getName())
                .fillPassword(LoremIpsum.getInstance().getTitle(1))
                .fillConfirmPassword(LoremIpsum.getInstance().getTitle(1))
                .clickRegisterBtnSFail();
        Assert.assertTrue(registerPage.hasRequiredFieldMessage(1));

    }

    @Test
    public void shouldDisplayZipCodeRequiredValidationMessage() {
        RegisterPage registerPage = pg.navigateToPage(CustomerLoginPage.class)
                .clickRegisterLink()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .fillAddress("123 Main St")
                .fillCity(LoremIpsum.getInstance().getCity())
                .fillState(LoremIpsum.getInstance().getStateAbbr())
                .fillSSN(LoremIpsum.getInstance().getPhone())
                .fillUsername(LoremIpsum.getInstance().getName())
                .fillPassword(LoremIpsum.getInstance().getTitle(1))
                .fillConfirmPassword(LoremIpsum.getInstance().getTitle(1))
                .clickRegisterBtnSFail();
        Assert.assertTrue(registerPage.hasRequiredFieldMessage(1));

    }

    @Test
    public void shouldDisplaySSNRequiredValidationMessage() {
        RegisterPage registerPage = pg.navigateToPage(CustomerLoginPage.class)
                .clickRegisterLink()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .fillAddress("123 Main St")
                .fillCity(LoremIpsum.getInstance().getCity())
                .fillState(LoremIpsum.getInstance().getStateAbbr())
                .fillZipCode(LoremIpsum.getInstance().getZipCode())
                .fillUsername(LoremIpsum.getInstance().getName())
                .fillPassword(LoremIpsum.getInstance().getTitle(1))
                .fillConfirmPassword(LoremIpsum.getInstance().getTitle(1))
                .clickRegisterBtnSFail();
        Assert.assertTrue(registerPage.hasRequiredFieldMessage(1));

    }

    @Test
    public void shouldDisplayUsernameRequiredValidationMessage() {
        RegisterPage registerPage = pg.navigateToPage(CustomerLoginPage.class)
                .clickRegisterLink()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .fillAddress("123 Main St")
                .fillCity(LoremIpsum.getInstance().getCity())
                .fillState(LoremIpsum.getInstance().getStateAbbr())
                .fillZipCode(LoremIpsum.getInstance().getZipCode())
                .fillSSN(LoremIpsum.getInstance().getPhone())
                .fillPassword(LoremIpsum.getInstance().getTitle(1))
                .fillConfirmPassword(LoremIpsum.getInstance().getTitle(1))
                .clickRegisterBtnSFail();
        Assert.assertTrue(registerPage.hasRequiredFieldMessage(1));

    }

    @Test
    public void shouldDisplayPasswordRequiredValidationMessage() {
        RegisterPage registerPage = pg.navigateToPage(CustomerLoginPage.class)
                .clickRegisterLink()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .fillAddress("123 Main St")
                .fillCity(LoremIpsum.getInstance().getCity())
                .fillState(LoremIpsum.getInstance().getStateAbbr())
                .fillZipCode(LoremIpsum.getInstance().getZipCode())
                .fillSSN(LoremIpsum.getInstance().getPhone())
                .fillUsername(LoremIpsum.getInstance().getName())
                .fillConfirmPassword(LoremIpsum.getInstance().getTitle(1))
                .clickRegisterBtnSFail();
        Assert.assertTrue(registerPage.hasRequiredFieldMessage(1));

    }

    @Test
    public void shouldDisplayConfirmPasswordRequiredValidationMessage() {
        RegisterPage registerPage = pg.navigateToPage(CustomerLoginPage.class)
                .clickRegisterLink()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .fillAddress("123 Main St")
                .fillCity(LoremIpsum.getInstance().getCity())
                .fillState(LoremIpsum.getInstance().getStateAbbr())
                .fillZipCode(LoremIpsum.getInstance().getZipCode())
                .fillSSN(LoremIpsum.getInstance().getPhone())
                .fillUsername(LoremIpsum.getInstance().getName())
                .fillPassword(LoremIpsum.getInstance().getTitle(1))
                .clickRegisterBtnSFail();
        Assert.assertTrue(registerPage.hasRequiredFieldMessage(1));

    }

    @Test
    public void shouldRegisterSuccessfully() {
        String username = LoremIpsum.getInstance().getTitle(1);
        OverviewPage registerPage = pg.navigateToPage(CustomerLoginPage.class)
                .clickRegisterLink()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .fillAddress("123 Main St")
                .fillCity(LoremIpsum.getInstance().getCity())
                .fillState(LoremIpsum.getInstance().getStateAbbr())
                .fillZipCode(LoremIpsum.getInstance().getZipCode())
                .fillSSN(LoremIpsum.getInstance().getPhone())
                .fillUsername(LoremIpsum.getInstance().getName())
                .fillPassword(username)
                .fillConfirmPassword(username)
                .clickRegisterBtnSuccessfully();
        Assert.assertTrue(registerPage.hasLogoutLink());
    }
}

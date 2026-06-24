package com.parabank.parasoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage fillFirstName(String firstName) {
        fillText(By.id("customer.firstName"), firstName);
        return this;
    }

    public RegisterPage fillLastName(String lastName) {
        fillText(By.id("customer.lastName"), lastName);
        return this;
    }

    public RegisterPage fillAddress(String address) {
        fillText(By.id("customer.address.street"), address);
        return this;
    }

    public RegisterPage fillCity(String city) {
        fillText(By.id("customer.address.city"), city);
        return this;
    }

    public RegisterPage fillState(String state) {
        fillText(By.id("customer.address.state"), state);
        return this;
    }

    public RegisterPage fillZipCode(String zipCode) {
        fillText(By.id("customer.address.zipCode"), zipCode);
        return this;
    }

    public RegisterPage fillPhone(String phone) {
        fillText(By.id("customer.phoneNumber"), phone);
        return this;
    }

    public RegisterPage fillSSN(String ssn) {
        fillText(By.id("customer.ssn"), ssn);
        return this;
    }

    public RegisterPage fillUsername(String username) {
        fillText(By.id("customer.username"), username);
        return this;
    }

    public RegisterPage fillPassword(String password) {
        fillText(By.id("customer.password"), password);
        return this;
    }

    public RegisterPage fillConfirmPassword(String confirmPassword) {
        fillText(By.id("repeatedPassword"), confirmPassword);
        return this;
    }

    public OverviewPage clickRegisterBtnSuccessfully() {
        clickElement(By.cssSelector("input[value='Register']"));
        return navigateToPage(OverviewPage.class);
    }

    public RegisterPage clickRegisterBtnSFail() {
        clickElement(By.cssSelector("input[value='Register']"));
        return this;
    }

    public boolean hasRequiredFieldMessage(int number){
        return getElements(By.cssSelector("span[class='error']")).size() >= number;
    }
}

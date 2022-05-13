package com.bank.testsuite;

import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class BankTest extends TestBase {

        HomePage homePage;
        AddCustomerPage addCustomerPage;
        BankManagerLoginPage bankManagerLoginPage;
        AccountPage accountPage;
        CustomerLoginPage customerLoginPage;
        CustomersPage customersPage;
        OpenAccountPage openAccountPage;

        @BeforeMethod(alwaysRun = true)
        public void inIt(){
            homePage = new HomePage();
            addCustomerPage = new AddCustomerPage();
            bankManagerLoginPage = new BankManagerLoginPage();
            accountPage = new AccountPage();
            customerLoginPage = new CustomerLoginPage();
            customersPage = new CustomersPage();
            openAccountPage = new OpenAccountPage();
        }
        @Test(groups = {"sanity","regression"})
        public void bankManagerShouldAddCustomerSuccessfully(){
            homePage.clickOnBankManagerLoginTab();
            bankManagerLoginPage.clickOnAddCustomerTab();
            addCustomerPage.enterFirstName("Sam");
            addCustomerPage.enterLastName("Smith");
            addCustomerPage.enterPostcode("WD24 4DX");
            addCustomerPage.clickOnAddCustomerButton();
            addCustomerPage.verifyingPopUpMessage();
            addCustomerPage.acceptPopUpMessage();
        }

        @Test(priority = 1,groups = {"sanity","smoke","regression"})
        public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException {
            bankManagerShouldAddCustomerSuccessfully();
            bankManagerLoginPage.clickOnOpenAccountTab();
            openAccountPage.selectCustomerName("Sam Smith");
            openAccountPage.selectCurrency("Pound");
            openAccountPage.clickOnProcessButton();
            openAccountPage.verifyAccountCreatedSuccessfullyText();
            addCustomerPage.acceptPopUpMessage();
            homePage.clickOnHomeButton();
        }

        @Test(priority = 2,groups = {"smoke","regression"})
        public void customerShouldLoginAndLogoutSuccessfully() throws InterruptedException {
            bankManagerShouldOpenAccountSuccessfully();
            homePage.clickOnCustomerLoginButton();
            customersPage.selectCustomerName("Sam Smith");
            customerLoginPage.clickOnLoginButton();
            accountPage.verifyLogoutTabVisible();
            accountPage.clickOnLogoutButton();
            accountPage.verifyYourNameTextIsDisplayed("Your Name");
        }

        @Test(priority = 3,groups = {"smoke","regression"})
        public void customerShouldDepositMoneySuccessfully() throws InterruptedException {
            customerShouldLoginAndLogoutSuccessfully();
            customersPage.selectCustomerName("Sam Smith");
            customerLoginPage.clickOnLoginButton();
            accountPage.clickOnDepositTab();
            accountPage.inputDepositAmount("50000");
            accountPage.clickOnSubmitButton();
            accountPage.verifyDepositSuccessfulMessage("Deposit Successful");
        }
        @Test(priority = 4,groups = {"regression"})
        public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
            customerShouldDepositMoneySuccessfully();
            homePage.clickOnHomeButton();
            homePage.clickOnCustomerLoginButton();
            customersPage.selectCustomerName("Sam Smith");
            customerLoginPage.clickOnLoginButton();
            accountPage.clickOnWithdrawalTab();
            accountPage.inputWithdrawAmount("15000");
            accountPage.clickOnWithdrawButton();
            accountPage.verifyTransactionSuccessfulMessage("Transaction Successful");
        }
}

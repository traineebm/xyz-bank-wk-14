package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AccountPage extends Utility {

        public AccountPage() {
            PageFactory.initElements(driver, this);
        }

        @FindBy(xpath = "//button[contains(text(),'Logout')]")
        WebElement logoutTab;

        @FindBy(xpath = "//label[contains(text(),'Your Name :')]")
        WebElement yourNameText;

        @FindBy(xpath = "//strong/span[@class='fontBig ng-binding']")
        WebElement welcomeCustomerNameText;

        @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[3]/button[2]")
        WebElement depositTab;

        @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]")
        WebElement depositAmountField;

        @FindBy(xpath = "//button[@type='submit']")
        WebElement submitButton;

        @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]")
        WebElement depositFinalTab;

        @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
        WebElement depositSuccessfulMessage;

        @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[3]/button[3]")
        WebElement withdrawalTab;

        @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]")
        WebElement withdrawalAmountField;

        @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/button[1]")
        WebElement withdrawalButton;

        @FindBy(xpath = "//span[contains(text(),'Transaction successful')]")
        WebElement transactionSuccessfulMessage;


    public void clickOnLogoutButton(){
        clickOnElement(logoutTab);
        CustomListeners.test.log(Status.PASS,"Click on logout tab ");
        Reporter.log("Click on logout tab "+"<br>");
    }

    public void verifyYourNameTextIsDisplayed(String text){
        verifyThatTextIsDisplayed(yourNameText, text);
        CustomListeners.test.log(Status.PASS,"Verify 'Your Name' Text "+text);
        Reporter.log("Verify 'Your Name' Text "+text+"<br>");
    }

    public void clickOnDepositTab(){
        clickOnElement(depositTab);
        CustomListeners.test.log(Status.PASS,"Click on deposit tab ");
        Reporter.log("Click on deposit tab "+"<br>");
    }

    public void inputDepositAmount(String amount){
        sendTextToElement(depositAmountField, amount);
        CustomListeners.test.log(Status.PASS,"Enter the deposit amount " + amount);
        Reporter.log("Enter the deposit amount: "+amount+ "<br>");
    }

    public void clickOnSubmitButton(){
        clickOnElement(submitButton);
        CustomListeners.test.log(Status.PASS,"Click on deposit submit button ");
        Reporter.log("Click on deposit submit button"+"<br>");
    }

    public void verifyDepositSuccessfulMessage(String message){
        verifyThatTextIsDisplayed(depositSuccessfulMessage, message);
        CustomListeners.test.log(Status.PASS,"Verify 'Deposit Successfully' message " + message);
        Reporter.log("Verify 'Deposit Successfully' message"+ "<br>");

    }

    public void clickOnWithdrawalTab(){
        clickOnElement(withdrawalTab);
        CustomListeners.test.log(Status.PASS,"Click on withdrawal button ");
        Reporter.log("Click on withdrawal button"+ "<br>");
    }

    public void inputWithdrawAmount(String amount){
        sendTextToElement(withdrawalAmountField, amount);
        CustomListeners.test.log(Status.PASS,"Enter withdraw amount: " + amount);
        Reporter.log("Enter withdraw amount: "+amount+"<br>");
    }

    public void clickOnWithdrawButton(){
        clickOnElement(withdrawalButton);
        CustomListeners.test.log(Status.PASS,"Click on withdraw button ");
        Reporter.log("Click on withdraw button"+ "<br>");
    }

    public void verifyTransactionSuccessfulMessage(String message){
        verifyThatTextIsDisplayed(transactionSuccessfulMessage, message);
        CustomListeners.test.log(Status.PASS,"Verify 'Transaction Successful' message " + message);
        Reporter.log("Verify  'Transaction Successful' message"+ "<br>");
    }
    public void verifyLogoutTabVisible(){
        verifyThatElementIsDisplayed(logoutTab);
        CustomListeners.test.log(Status.PASS,"Verify logout tab visible ");
        Reporter.log("Verify logout tab is visible"+ "<br>");
    }


























    }



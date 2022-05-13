package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerLoginButton;

    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerLoginButton;

    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement homeButton;


    public void clickOnBankManagerLoginTab() {
        clickOnElement(bankManagerLoginButton);
        CustomListeners.test.log(Status.PASS, "Click on bank manager login tab ");
        Reporter.log("Click on bank manager login tab " + "<br>");
    }

    public void clickOnCustomerLoginButton() {
        clickOnElement(customerLoginButton);
        CustomListeners.test.log(Status.PASS, "Click on customer login button ");
        Reporter.log("Click on customer login button" + "<br>");
    }

    public void clickOnHomeButton() {
        clickOnElement(homeButton);
        CustomListeners.test.log(Status.PASS, "Click on home button ");
        Reporter.log("click on home button" + "<br>");
    }

}
package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {

    public AddCustomerPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement getFirstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement getLastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement getPostCode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement getAddCustomerButton;


    public void enterFirstName(String firstname) {
        sendTextToElement(getFirstName,firstname);
        CustomListeners.test.log(Status.PASS,"Enter first name: " + firstname);
        Reporter.log("Enter first name: " + firstname + "<br>");
    }

    public void enterLastName(String lastname) {
        sendTextToElement(getLastName,lastname);
        CustomListeners.test.log(Status.PASS,"Enter last name: " + lastname);
        Reporter.log("Enter last name: " + lastname + "<br>");
    }

    public void enterPostcode(String postcode) {
        sendTextToElement(getPostCode, postcode);
        CustomListeners.test.log(Status.PASS,"Enter postcode: " + postcode);
        Reporter.log("Enter postcode: " + postcode + "<br>");
    }

    public void clickOnAddCustomerButton() {
        clickOnElement(getAddCustomerButton);
        CustomListeners.test.log(Status.PASS,"Click on add customer button ");
        Reporter.log("Click on add customer button" + "<br>");
    }

    public void acceptPopUpMessage(){
        acceptAlert();
        CustomListeners.test.log(Status.PASS,"Accept the alert ");
        Reporter.log("Accept the alert" + "<br>");
    }

    public void verifyingPopUpMessage(){
        String actual = getTextFromAlert();
        String expected = "Customer added successfully with customer id :7";
        Assert.assertEquals(actual.substring(0,25),expected.substring(0,25),"wrong popup message");
        CustomListeners.test.log(Status.PASS,"Verifying 'customer added successfully' popup text");
        Reporter.log("Verifying 'customer added successfully' popup text" + "<br>");
    }

}

package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registration {
    public WebDriver driver;

    public Registration(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    private WebElement writeFirstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    private WebElement writeLastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    private WebElement writePostCode;

    @FindBy(xpath = ("//button[@type='submit']"))
    private WebElement pressAddCustomer;

    @FindBy(xpath = "//div[@ui-view class='ng-scope']")
    private WebElement pressOK;

    public void inputFirstName(String fName) { writeFirstName.sendKeys(fName); }

    public void inputLastName(String lName) {
        writeLastName.sendKeys(lName);
    }

    public void inputPostCode(String pCode) {
        writePostCode.sendKeys(pCode);
    }

    public void pressADDCustomer() { pressAddCustomer.click(); }

    public void pressOk() {
        pressOK.click();
    }

    public void inputRightRegistration(String fName, String lName, String pCode) {
        inputFirstName(fName);
        inputLastName(lName);
        inputPostCode(pCode);
        pressADDCustomer();
       // pressOk();
    }
}

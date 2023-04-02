package org.test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Sort {
    public WebDriver driver;

    public Sort(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='#']")
    private WebElement pressFirstName;

    public void clickFirstName() {
        pressFirstName.click();
    }

    public void clickFirstNameTwice() {
        pressFirstName.click();
        pressFirstName.click();
    }




}

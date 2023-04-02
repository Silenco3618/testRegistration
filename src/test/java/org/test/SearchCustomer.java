package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomer {
    public WebDriver driver;

    public SearchCustomer(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='text']")
    private WebElement pressSearchCustomer;

    public void setPressSearchCustomer(String sCustomer) {
        pressSearchCustomer.click();
        pressSearchCustomer.sendKeys(sCustomer);
    }


    @FindBy(xpath = "//a[@ng-click='sortType = 'lName'; sortReverse = !sortReverse']")
    private WebElement pressLastName;

    @FindBy(xpath = "//a[@ng-click='sortType = 'postCd'; sortReverse = !sortReverse']")
    private WebElement pressPostCode;

}

package org.test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ChooseTabs {
    private static String PAGE_URL = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager";
    public WebDriver driver;

    @FindBy(css = "[ng-class='btnClass1']")
    private WebElement signInButtonAddCustomer;
    //xpath = "//button[@ng-class='btnClass1']"

    @FindBy(css = "[ng-class='btnClass3']")
    private WebElement signInButtonCustomers;

    public ChooseTabs(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void clickAddCustomers() {
        signInButtonAddCustomer.click();
    }

    public void clickCustomers() {
        signInButtonCustomers.click();
    }
}


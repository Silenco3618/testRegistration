package org.test.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.test.ChooseTabs;
import org.test.Registration;
import org.test.SearchCustomer;

import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ValidAddCustomersTest {
    private WebDriver driver;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--headless");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void successAddCustomer() {
        ChooseTabs chooseTabs = new ChooseTabs(driver);
        chooseTabs.clickAddCustomers();
        Registration registration = new Registration(driver);
        registration.inputRightRegistration("Екатерина", "Иванова", "123456");
        //ChooseTabs chooseTabs1 = new ChooseTabs(driver);
        //chooseTabs1.clickCustomers();
        //SearchCustomer searchCustomer = new SearchCustomer(driver);
        //searchCustomer.setPressSearchCustomer("Екатерина");
       // String expected = "Екатерина";
       // String actual = driver.findElement(By.linkText("Екатерина")).getText().trim();
       // assertEquals(expected, actual);
        //assertTrue((BooleanSupplier) driver.findElement(By.linkText("Customer added successfully with customer id :6")));


        //String expected = "Customer added successfully with customer id :6";
        //String actual = driver.findElement(By.xpath("//div[@ui-view class='ng-scope']::after")).getText().trim();
        //assertEquals(expected, actual);
    }

    @Test
    public void addCustomerDiphysisFirstName() {
        ChooseTabs chooseTabs = new ChooseTabs(driver);
        chooseTabs.clickAddCustomers();
        Registration registration = new Registration(driver);
        registration.inputRightRegistration("Екатерина-Юлия", "Иванова", "123456");
    }

    @Test
    public void addCustomerDiphysisLastName() {
        ChooseTabs chooseTabs = new ChooseTabs(driver);
        chooseTabs.clickAddCustomers();
        Registration registration = new Registration(driver);
        registration.inputRightRegistration("Екатерина", "Иванова-Щербакова", "123456");
    }

    @Test
    public void addCustomerDiphysisPostCode() {
        ChooseTabs chooseTabs = new ChooseTabs(driver);
        chooseTabs.clickAddCustomers();
        Registration registration = new Registration(driver);
        registration.inputRightRegistration("Екатерина", "Иванова", "12-3456");
    }

    @Test
    public void addCustomerTwoSymbolsFirstName() {
        ChooseTabs chooseTabs = new ChooseTabs(driver);
        chooseTabs.clickAddCustomers();
        Registration registration = new Registration(driver);
        registration.inputRightRegistration("Ек", "Иванова", "123456");
    }

    @Test
    public void addCustomerTwoSymbolsLastName() {
        ChooseTabs chooseTabs = new ChooseTabs(driver);
        chooseTabs.clickAddCustomers();
        Registration registration = new Registration(driver);
        registration.inputRightRegistration("Екатерина", "Ив", "123456");
    }

    @Test
    public void addCustomerTwentySymbolsFirstAndLastName() {
        ChooseTabs chooseTabs = new ChooseTabs(driver);
        chooseTabs.clickAddCustomers();
        Registration registration = new Registration(driver);
        registration.inputRightRegistration("Екатериналбмиатвлюам", "Ивановаваияваяивиаяв", "123456");
    }
}

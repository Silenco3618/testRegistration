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

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvalidAddCustomersTest {

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
    public void addCustomerInEnglishFirstName() {
        ChooseTabs chooseTabs = new ChooseTabs(driver);
        chooseTabs.clickAddCustomers();
        Registration registration = new Registration(driver);
        registration.inputRightRegistration("Ekaterina", "Иванова", "123456");
        String expected = "Введите имя на русском языке";
        String actual = driver.findElement(By.cssSelector("[data-test-id=order-success]")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void addCustomerInEnglishLastName() {
        ChooseTabs chooseTabs = new ChooseTabs(driver);
        chooseTabs.clickAddCustomers();
        Registration registration = new Registration(driver);
        registration.inputRightRegistration("Ekaterina", "Ivanova", "123456");
    }

    @Test
    public void addCustomerFirstNameSpace() {
        ChooseTabs chooseTabs = new ChooseTabs(driver);
        chooseTabs.clickAddCustomers();
        Registration registration = new Registration(driver);
        registration.inputRightRegistration("Екатерина Юлия", "Иванова", "123456");
    }

    @Test
    public void addCustomerLastNameSpace() {
        ChooseTabs chooseTabs = new ChooseTabs(driver);
        chooseTabs.clickAddCustomers();
        Registration registration = new Registration(driver);
        registration.inputRightRegistration("Екатерина", "Иванова Щербакова", "123456");
    }

    @Test
    public void addCustomerFirstNameLittleLetter() {
        ChooseTabs chooseTabs = new ChooseTabs(driver);
        chooseTabs.clickAddCustomers();
        Registration registration = new Registration(driver);
        registration.inputRightRegistration("екатерина", "Иванова", "123456");
    }

    @Test
    public void addCustomerLastNameLittleLetter() {
        ChooseTabs chooseTabs = new ChooseTabs(driver);
        chooseTabs.clickAddCustomers();
        Registration registration = new Registration(driver);
        registration.inputRightRegistration("Екатерина", "иванова", "123456");
    }

    @Test
    public void addCustomerPageCodeSymbols() {
        ChooseTabs chooseTabs = new ChooseTabs(driver);
        chooseTabs.clickAddCustomers();
        Registration registration = new Registration(driver);
        registration.inputRightRegistration("Екатерина", "иванова", "123456");
    }

    @Test
    public void addCustomerFirstNameEmpty() {
        ChooseTabs chooseTabs = new ChooseTabs(driver);
        chooseTabs.clickAddCustomers();
        Registration registration = new Registration(driver);
        registration.inputRightRegistration("", "Иванова", "123456");
    }

    @Test
    public void addCustomerLastNameEmpty() {
        ChooseTabs chooseTabs = new ChooseTabs(driver);
        chooseTabs.clickAddCustomers();
        Registration registration = new Registration(driver);
        registration.inputRightRegistration("Екатерина", "", "123456");
    }

    @Test
    public void addCustomerPageCodeEmpty() {
        ChooseTabs chooseTabs = new ChooseTabs(driver);
        chooseTabs.clickAddCustomers();
        Registration registration = new Registration(driver);
        registration.inputRightRegistration("Екатерина", "Иванова", "");
    }
}

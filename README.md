https://docs.google.com/spreadsheets/d/1IQ9jsSGZ6R8Q1Om4LDI7guzYrh_95N_D909HF_uivSU/edit#gid=0
package org.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {
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
    }

    @Test
    public void successAddCustomer() {
        AddCustomer addCustomer = new AddCustomer(driver);
        loginPage.loginPages("standard_user", "secret_sauce");
        AddPage addPage = new AddPage(driver);
        addPage.addPages();
        InformationPage informationPage = new InformationPage(driver);
        informationPage.informationPages("Наталья", "Иванова", "test");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Swag Labs"));
        String expected = "Thank you for your order!";
        String actual = driver.findElement(By.xpath("//*[@id='checkout_complete_container']/h2")).getText().trim();
        assertEquals(expected, actual);
    }

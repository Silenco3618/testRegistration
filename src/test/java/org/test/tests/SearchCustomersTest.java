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
import org.test.SearchCustomer;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchCustomersTest {


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
    public void successSearchFirstName() {
        ChooseTabs chooseTabs = new ChooseTabs(driver);
        chooseTabs.clickCustomers();
        SearchCustomer searchCustomer = new SearchCustomer(driver);
        searchCustomer.setPressSearchCustomer("Hermoine");
        String expected = "Hermoine";
        String actual = driver.findElement(By.xpath("//td[@class='ng-binding']")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void successSearchLastName() {
        ChooseTabs chooseTabs = new ChooseTabs(driver);
        chooseTabs.clickCustomers();
        SearchCustomer searchCustomer = new SearchCustomer(driver);
        searchCustomer.setPressSearchCustomer("Granger");
        String expected = "Granger";
        String actual = driver.findElement(By.xpath("//td[@class='ng-binding'][2]")).getText().trim();
        assertEquals(expected, actual);
    }

    @Test
    public void successSearchPostCode() {
        ChooseTabs chooseTabs = new ChooseTabs(driver);
        chooseTabs.clickCustomers();
        SearchCustomer searchCustomer = new SearchCustomer(driver);
        searchCustomer.setPressSearchCustomer("E55656");
        String expected = "E55656";
        String actual = driver.findElement(By.xpath("//td[@class='ng-binding'][3]")).getText().trim();
        assertEquals(expected, actual);
    }
}

package com.ait.qa55;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class FirstHomeworkTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void findElementsByBasicLocators() {
        // Search by ID — search input field
        WebElement searchField = driver.findElement(By.id("small-searchterms"));
        System.out.println("Search field placeholder: " + searchField.getAttribute("placeholder"));

        // Search by className — logo
        WebElement logo = driver.findElement(By.className("header-logo"));
        System.out.println("Is logo displayed: " + logo.isDisplayed());

        // Search by linkText — registration link
        WebElement registerLink = driver.findElement(By.linkText("Register"));
        System.out.println("Text of registration link: " + registerLink.getText());

        // Search by partialLinkText — login link
        WebElement loginLink = driver.findElement(By.partialLinkText("Log"));
        System.out.println("Found link: " + loginLink.getText());
    }

    @Test
    public void findElementsByCssSelectors() {
        // Search by tag selector
        WebElement mainTitle = driver.findElement(By.cssSelector("h2"));
        System.out.println("Section title: " + mainTitle.getText());

        // Search by ID — using #
        driver.findElement(By.cssSelector("#small-searchterms"));

        // Search by class — using .
        driver.findElement(By.cssSelector(".header-logo"));

        // Search by attribute
        driver.findElement(By.cssSelector("input[name='q']"));

        // Attribute contains value
        driver.findElement(By.cssSelector("a[href*='register']"));

        // Attribute starts with value
        driver.findElement(By.cssSelector("a[href^='/log']"));

        // Attribute ends with value
        driver.findElement(By.cssSelector("a[href$='login']"));

        // Tag + class
        driver.findElement(By.cssSelector("div.master-wrapper-page"));
    }

    @Test
    public void findElementsByXpath() {
        // Search by tag
        driver.findElement(By.xpath("//input"));

        // Search by ID
        driver.findElement(By.xpath("//input[@id='small-searchterms']"));

        // Search by class
        driver.findElement(By.xpath("//div[@class='header-logo']"));

        // Search by exact text
        driver.findElement(By.xpath("//a[text()='Register']"));

        // Search by partial text (contains)
        driver.findElement(By.xpath("//a[contains(text(),'Log')]"));

        // Attribute starts-with
        driver.findElement(By.xpath("//a[starts-with(@href, '/log')]"));

        // Navigate up to parent
        driver.findElement(By.xpath("//span[@class='cart-label']/.."));

        // Search for ancestors
        driver.findElement(By.xpath("//input[@id='small-searchterms']/ancestor::form"));

        // Search for a sibling element
        driver.findElement(By.xpath("//input[@id='small-searchterms']/following-sibling::input[@type='submit']"));
    }
}

package com.ait.qa55;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstHomeworkTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void findElementById() {
//        WebElement register = driver.findElement(By.linkText("Register"));
//        register.click();
        driver.findElement(By.id("dialog-notifications-success"));
    }

    @Test
    public  void findElementByClassName() {
        driver.findElement(By.className("ico-login"));
    }
}

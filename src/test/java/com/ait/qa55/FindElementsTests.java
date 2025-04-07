package com.ait.qa55;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FindElementsTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://ilcarro.web.app");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void findElementBySimpleLocators(){
        //by id
        driver.findElement(By.id("city"));
        //by className
        driver.findElement(By.className("header"));
        System.out.println(driver.findElement(By.className("header")).getText());
        //by linkText
        driver.findElement(By.linkText("Let the car work"));
        //by partialLinkText
        driver.findElement(By.partialLinkText("car"));

    }

    @Test
    public void findElementByCssSelector(){
        //tagName == css
        driver.findElement(By.cssSelector("h1"));

        //id -> css(#)
        driver.findElement(By.cssSelector("#city"));

        //by className -> css(.)
        driver.findElement(By.cssSelector(".header"));

        //[attribute = 'value']
        driver.findElement(By.cssSelector("[href='/registration?url=%2Fsearch']"));

        //contains -> *
        driver.findElement(By.cssSelector("[href*='/registration']"));

        //start -> ^
        driver.findElement(By.cssSelector("[href^='/reg']"));

        //end -> $
        driver.findElement(By.cssSelector("[href$='search']"));
    }
}




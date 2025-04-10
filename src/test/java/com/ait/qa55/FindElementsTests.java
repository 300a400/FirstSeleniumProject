package com.ait.qa55;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void findElementBySimpleLocators() {
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
    public void findElementByCssSelector() {
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

        //tag+id
        driver.findElement(By.cssSelector("input#city"));

        //tag+id+[attr='value']
        driver.findElement(By.cssSelector("input#city[type='text']"));

        //tag+class
        driver.findElement(By.cssSelector("div.mobile-header"));
        driver.findElement(By.cssSelector("div.search-card"));


        //tag+attribute
        driver.findElement(By.cssSelector("a[href='/registration?url=%2Fsearch']"));

    }

    @Test
    public void findElementByXpath(){
        //tag ->xpath -> //tag
        //driver.findElement(By.tagName("h1"));
        driver.findElement(By.xpath("//h1"));
        //id->xpath -> //*[@id='value']
        //driver.findElement(By.id("city"));
        driver.findElement(By.xpath("//input[@id='city']"));
        //className-> //*[@class='value']
        //driver.findElement(By.className("header"));
        driver.findElement(By.xpath("//div[@class='header']"));
        //contains-> //*[contains(.,'Text')]
        driver.findElement(By.xpath("//h2[contains(.,'Yalla')]"));
        //equal-> //*[text()='Text']
        driver.findElement(By.xpath("//h2[text()='Type your data and hit Yalla!']"));
        driver.findElement(By.xpath("//h2[.='Type your data and hit Yalla!']"));
        //start-with->//*[starts-with(@attr,'StartText')]
        driver.findElement(By.xpath("//label[starts-with(@for,'ci')]"));
        //move up
        driver.findElement(By.xpath("//a[@class='navigation-link']/.."));
        //parent
        driver.findElement(By.xpath("//h1/parent::*"));
        driver.findElement(By.xpath("//h1/parent::div"));
        driver.findElement(By.xpath("//h1/.."));
        //ancestor
        driver.findElement(By.xpath("//h1/ancestor::*"));//all
        driver.findElement(By.xpath("//h1/ancestor::div"));//two options
        driver.findElement(By.xpath("//h1/ancestor::div[2]"));//one options
        //following-sibling
        driver.findElement(By.xpath("//h1/following-sibling::form"));
    }
}




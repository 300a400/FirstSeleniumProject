package com.ait.qa55;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TableTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table.asp");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void findElementTableWithCss() {
        // print a number of rows
        List<WebElement> rows = driver.findElements(By.cssSelector("tr"));
        System.out.println(rows.size());
        for (WebElement el : rows) {
            System.out.println(el.getText());
        }
        //get row 4
        WebElement row4 = driver.findElement(By.cssSelector("tr:nth-child(4)"));//xpath - > //tr[4]
        System.out.println(row4.getText());
        //get first item in row
        WebElement item1 = driver.findElement(By.cssSelector("tr:nth-child(7) td:nth-child(1)"));
        System.out.println(item1.getText());
        //get last element
        WebElement canada = driver.findElement(By.cssSelector("tr:nth-child(8) td:last-child"));
        System.out.println(canada.getText());
    }

    @Test
    public void findElementTableWithXpath() {

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
        System.out.println("Количество строк в таблице: " + rows.size());

        for (WebElement el : rows) {
            System.out.println(el.getText());
        }

        WebElement row4 = driver.findElement(By.xpath("//table[@id='customers']//tr[4]"));
        System.out.println("Содержимое строки 4: " + row4.getText());

        WebElement item1 = driver.findElement(By.xpath("//table[@id='customers']//tr[7]/td[1]"));
        System.out.println("Первая ячейка строки 7: " + item1.getText());

        WebElement canada = driver.findElement(By.xpath("//table[@id='customers']//tr[8]/td[last()]"));
        System.out.println("Последняя ячейка строки 8: " + canada.getText());
    }
}


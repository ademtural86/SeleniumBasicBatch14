package com.Syntax.class07;

import com.Syntax.class06.HomeWork;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class HomeWork2 {
    public static void main(String[] args) {
        /***HomeWork 2**
        *Implicit wait**

        1. goto https://syntaxprojects.com/dynamic-data-loading-demo.php

        2. click on get New User
        3. get the firstname  of user and print it on console*/

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/user/AppData/Local/Google/Chrome/User Data/Default");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://syntaxprojects.com/dynamic-data-loading-demo.php");
        driver.manage().window().maximize();

        WebElement saveBtn = driver.findElement(By.xpath("//button[@id='save']"));
        saveBtn.click();

        WebElement firstName = driver.findElement(By.xpath("//p[contains(text(),'First Name :')]"));
        System.out.println(firstName.getText());
        driver.quit();
    }
}

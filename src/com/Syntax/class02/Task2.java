package com.Syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        // create a WebDriver instance
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/user/AppData/Local/Google/Chrome/User Data/Default");
        WebDriver driver= new ChromeDriver(options);

        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Create New Account")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("firstname")).sendKeys("testerName");
        driver.findElement(By.name("lastname")).sendKeys("testerSurName");
        driver.findElement(By.className("_8ien")).click();
        driver.quit();
    }
}

package com.Syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XpathDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        // create a WebDriver instance
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/user/AppData/Local/Google/Chrome/User Data/Default");
        WebDriver driver= new ChromeDriver(options);
//        goto fb.com
        driver.get("https://www.facebook.com/");
//        enter the username
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Abracadabra");

//        click on forgot password
        driver.findElement(By.xpath("//a[text()='Forgotten password?']")).click();

    }
}

package com.Syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task {
    public static void main(String[] args) throws InterruptedException {
        /*
        Navigate to http://syntaxprojects.com/
        Click on start practicing
        click on simple form demo
        enter any text on first text box
        click on show message
        quit the browser
         */

        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        // create a WebDriver instance
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/user/AppData/Local/Google/Chrome/User Data/Default");
        WebDriver driver= new ChromeDriver(options);
//        goto fb.com
        driver.get("http://syntaxprojects.com/");
        driver.findElement(By.xpath("//a[contains(text(),'Start')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='basic']/div/a[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='user-message']")).sendKeys("Hi");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[starts-with(text(),'Show')]")).click();
        Thread.sleep(2000);
        driver.quit();
    }
}

package com.Syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        // create a WebDriver instance
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/user/AppData/Local/Google/Chrome/User Data/Default");
        WebDriver driver= new ChromeDriver(options);

        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        driver.manage().window().maximize();
        driver.findElement(By.id("customer.firstName")).sendKeys("testerName");
        driver.findElement(By.id("customer.lastName")).sendKeys("testerSurname");
        driver.findElement(By.id("customer.address.street")).sendKeys("testerAddressStreet");
        driver.findElement(By.id("customer.address.city")).sendKeys("testerCity");
        driver.findElement(By.id("customer.address.state")).sendKeys("testerState");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("12345");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("+32456615850");
        driver.findElement(By.id("customer.ssn")).sendKeys("12345");

        driver.findElement(By.id("customer.username")).sendKeys("testerUsername");
        driver.findElement(By.id("customer.password")).sendKeys("12345");
        driver.findElement(By.id("repeatedPassword")).sendKeys("12345");

        driver.findElement(By.className("button")).click();

        driver.close();
    }
}

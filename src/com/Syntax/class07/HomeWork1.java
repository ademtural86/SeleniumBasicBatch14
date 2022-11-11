package com.Syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HomeWork1 {
    public static void main(String[] args) throws InterruptedException {
    /*    **HomeWork 1**
        **WindowHandles**
        1.goto
        http://accounts.google.com/signup
        2.click on help and privacy btn
        3.click on community Button
        4.goto gmail.com page and enter your username in form (edited)
        Create your Google Account
        Hint1:
        u can save the window handle in variables for later use*/

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/user/AppData/Local/Google/Chrome/User Data/Default");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://accounts.google.com/signup");

        WebElement helpButton = driver.findElement(By.xpath("//a[text()='Help']"));
        helpButton.click();

        WebElement privacyButton = driver.findElement(By.xpath("//a[text()='Privacy']"));
        privacyButton.click();

        String currentHandle=driver.getWindowHandle();
        Set<String> allHandles = driver.getWindowHandles();


        for(String handle:allHandles){
            driver.switchTo().window(handle);
            String title = driver.getTitle();

            if(title.equalsIgnoreCase("Google Account Help")){
                WebElement communityButton = driver.findElement(By.xpath("//a[text()='Community']"));
                communityButton.click();
                break;
            }
        }

        driver.switchTo().window(currentHandle);

        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='Username']"));
        usernameInput.sendKeys("ademtural86");

        Thread.sleep(300);
        driver.quit();
    }
}

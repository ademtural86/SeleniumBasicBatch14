package com.Syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class HomeWork3 {
    public static void main(String[] args) {
        /*HomeWork3: (do not use thread .sleep  or Explicit wait)
        1.Goto https://syntaxprojects.com/dynamic-elements-loading.php
        2.Click on start button
        3. get the text Welcome Syntax technologies and print on console

        the text will be Empty

        write down  whatever the reason you understand  of text being empty after exploring DOM*/

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/user/AppData/Local/Google/Chrome/User Data/Default");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://syntaxprojects.com/dynamic-elements-loading.php");
        driver.manage().window().maximize();

        WebElement startBtn = driver.findElement(By.xpath("//button[@id='startButton']"));
        startBtn.click();

        WebElement infoTxt = driver.findElement(By.xpath("//h4[text()='Welcome Syntax Technologies']"));
        System.out.println("Text: "+infoTxt.getText());

        //It will print empty text because before we click start button the element is over there but
        //display attribute is none, so driver will find the element but can't get the text.
        driver.quit();

    }
}

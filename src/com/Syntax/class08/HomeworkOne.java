package com.Syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class HomeworkOne {
    public static void main(String[] args) {
        /*go to https://the-internet.herokuapp.com/dynamic_controls
        click on checkbox and click on remove
        verify the text
        click on enable verify the textbox is enabled
        enter text and click disable
        verify the textbox is disabled*/

        //        set the path to the driver to link it with our class    on mac u dont need .exe on windows u need .exe
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        // create a WebDriver instance
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/user/AppData/Local/Google/Chrome/User Data/Default");
        WebDriver driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        maximize
        driver.manage().window().maximize();
        //  go to the website
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement checkBox = driver.findElement(By.xpath("//div[@id='checkbox']/input"));
        checkBox.click();

        WebElement removeBtn = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeBtn.click();

        WebElement txt = driver.findElement(By.xpath("//p[@id='message']"));
        String messageTxt=txt.getText();

        if(messageTxt.equalsIgnoreCase("It's gone!")){
            System.out.println("Message Approved: "+messageTxt);
        } else {
            System.out.println("Message is invalid!");
        }

        WebElement enableBtn = driver.findElement(By.xpath("//button[text()='Enable']"));
        enableBtn.click();

        WebElement enableTxt = driver.findElement(By.id("message"));
        String enableTxtMsg=enableTxt.getText();

        if(enableTxtMsg.equalsIgnoreCase("It's enabled!")){
            System.out.println("Text message is enabled.: "+enableTxtMsg);
        } else {
            System.out.println("Text message isn't enabled");
        }

        WebElement inputText = driver.findElement(By.xpath("//form[@id='input-example']/input"));
        inputText.sendKeys("disable");

        WebElement disableBtn = driver.findElement(By.xpath("//button[text()='Disable']"));
        disableBtn.click();

        WebElement disableTxt = driver.findElement(By.xpath("//p[@id='message']"));
        String disableTxtMsg=disableTxt.getText();

        if(disableTxtMsg.equalsIgnoreCase("It's disabled!")){
            System.out.println("Text message is disabled.: "+disableTxtMsg);
        } else {
            System.out.println("Text message isn't disabled");
        }
    }
}

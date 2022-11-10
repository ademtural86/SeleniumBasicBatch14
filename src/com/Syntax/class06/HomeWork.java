package com.Syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HomeWork {
    public static void main(String[] args) throws InterruptedException {

        /*goto https://chercher.tech/practice/frames

        1.check the checkBox
        2. Select BabyCat from drop dwon
        3. Send text in text box "DONE" */

        //        set the path to the driver to link it with our class    on mac u dont need .exe on windows u need .exe
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        // create a WebDriver instance
        WebDriver driver = new ChromeDriver();
//        goto syntax project /dropDown demo
        driver.get("https://chercher.tech/practice/frames");
        driver.manage().window().maximize();

        driver.switchTo().frame("frame1");
        driver.switchTo().frame("frame3");
        WebElement innerFrameCheckBox = driver.findElement(By.xpath("//input[@id='a']"));
        innerFrameCheckBox.click();

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame2");
        WebElement dropDownAnimals = driver.findElement(By.xpath("//select[@id='animals']"));
        Select selectAnimals =new Select(dropDownAnimals);
        selectAnimals.selectByValue("babycat");

        driver.switchTo().defaultContent();

        driver.switchTo().frame("frame1");
        WebElement topicTextBox = driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input"));
        topicTextBox.sendKeys("DONE");
        Thread.sleep(3000);
        driver.quit();
    }
}

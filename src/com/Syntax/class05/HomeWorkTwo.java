package com.Syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomeWorkTwo {
    public static void main(String[] args) throws InterruptedException {
        /*1.Go to ebay.com
        2.get all the categories and print them in the console (in search bar you will see categories mentioned as dropdown)
        3.select Computers/Tables & Networking
        4.click on search
        5.verify the title*/

        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/user/AppData/Local/Google/Chrome/User Data/Default");
        WebDriver driver= new ChromeDriver(options);
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();

        WebElement dropDown = driver.findElement(By.xpath("//select[@id='gh-cat']"));
        Select select =new Select(dropDown);
        List<WebElement> categories = select.getOptions();

        for (WebElement category:categories) {
            System.out.println(category.getText());
        }

        select.selectByVisibleText("Computers/Tablets & Networking");

        WebElement searchButton = driver.findElement(By.xpath("//input[@id='gh-btn']"));
        searchButton.click();

        Thread.sleep(3000);

        if(driver.getTitle().contains("Tablets & Network")){
            System.out.println("You are on the right page.");
        }else {
            System.out.println("You are on the wrong page.");
        }

        Thread.sleep(3000);
        driver.quit();
    }
}

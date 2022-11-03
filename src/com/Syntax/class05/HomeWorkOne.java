package com.Syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class HomeWorkOne {
    public static void main(String[] args) throws InterruptedException {
        /*1.Go to facebook
        2.click on create New Account
        3.Fill out the whole form
        4.Take screenshot of filled out form manually and share in HW channel along with code*/

        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/user/AppData/Local/Google/Chrome/User Data/Default");
        WebDriver driver= new ChromeDriver(options);
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();

        driver.findElement(By.linkText("Create New Account")).click();
        Thread.sleep(2000);

        WebElement firstname = driver.findElement(By.name("firstname"));
        firstname.sendKeys("Adem");

        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.sendKeys("Tural");

        WebElement email = driver.findElement(By.name("reg_email__"));
        email.sendKeys("ademtural86@gmail.com");

        WebElement emailRepeat = driver.findElement(By.name("reg_email_confirmation__"));
        emailRepeat.sendKeys("ademtural86@gmail.com");

        WebElement newPass = driver.findElement(By.xpath("//input[@id='password_step_input']"));
        newPass.sendKeys("1234567890");

        WebElement dropDownMonth = driver.findElement(By.xpath("//select[@id='month']"));
        Select selectMonth =new Select(dropDownMonth);
        selectMonth.selectByIndex(4);

        WebElement dropDownDay = driver.findElement(By.xpath("//select[@id='day']"));
        Select selectDay =new Select(dropDownDay);
        selectDay.selectByVisibleText("6");

        WebElement dropDownYear = driver.findElement(By.xpath("//select[@id='year']"));
        Select selectYear =new Select(dropDownYear);
        selectYear.selectByValue("1986");

        WebElement sex = driver.findElement(By.xpath("//label[text()='Male']"));
        sex.click();

        Thread.sleep(3000);
        driver.quit();
    }
}

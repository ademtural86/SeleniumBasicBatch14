package com.Syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeworkOne {
    public static void main(String[] args) throws InterruptedException {
        /*Open chrome browser
        Go to “http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login”
        Enter valid username and password (username - Admin, password - Hum@nhrm123)
        Click on login button
        Then verify the message "Welcome Admin " is there on the top right corner*/

        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();

        WebElement userInputField = driver.findElement(By.cssSelector("input#txtUsername"));
        userInputField.sendKeys("Admin");

        WebElement passInputField = driver.findElement(By.cssSelector("input#txtPassword"));
        passInputField.sendKeys("Hum@nhrm123");

        WebElement loginButton = driver.findElement(By.cssSelector("input#btnLogin"));
        loginButton.click();

        WebElement loginMessage = driver.findElement(By.cssSelector("a#welcome"));
        String loginMessageText = loginMessage.getText();

        if(loginMessageText.equals("Welcome Admin")){
            System.out.println("Login Message = "+loginMessageText);
        } else {
            System.out.println("There is a problem.");
        }

        driver.quit();
    }
}

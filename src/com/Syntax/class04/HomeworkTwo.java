package com.Syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeworkTwo {
    public static void main(String[] args) {
        /*HRMS Application Negative Login:
        Open Chrome browser
        Go to “http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login”
        Enter valid username
        Leave password field empty
        Click on login button
        Verify error message with text “Password cannot be empty” is displayed.*/

        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();

        WebElement userInputField = driver.findElement(By.cssSelector("input#txtUsername"));
        userInputField.sendKeys("Admin");

        WebElement passInputField = driver.findElement(By.cssSelector("input#txtPassword"));
        passInputField.sendKeys("");

        WebElement loginButton = driver.findElement(By.cssSelector("input#btnLogin"));
        loginButton.click();

        WebElement loginMessage = driver.findElement(By.cssSelector("span#spanMessage"));
        String loginMessageText = loginMessage.getText();

        if(loginMessageText.equals("Password cannot be empty")){
            System.out.println("Error Message = "+ loginMessageText);
        } else {
            System.out.println("There is a problem.");
        }

        driver.quit();
    }
}

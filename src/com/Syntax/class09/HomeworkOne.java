package com.Syntax.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeworkOne {
    public static void main(String[] args) {
        /*http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login
        got to the url
        click on PIM
        click on Employee List
        from the table choose one id (it must be from the first page)
        and check the checkBox for that id   (your logic should be dynamic  , should work for any ID number)
        the user name is
        admin
        the password is
        Hum@nhrm123*/

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
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

        WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
        username.sendKeys("admin");

        WebElement password = driver.findElement(By.xpath("//input[@id='txtPassword']"));
        password.sendKeys("Hum@nhrm123");

        WebElement loginBtn = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginBtn.click();

        WebElement pimBtn = driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']"));
        pimBtn.click();

        WebElement employeeListBtn = driver.findElement(By.xpath("//a[@id='menu_pim_viewEmployeeList']"));
        employeeListBtn.click();

        List<WebElement> secondColumn = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]"));

        for (int i=0; i<secondColumn.size(); i++){
            String textID=secondColumn.get(i).getText();

            if (textID.equalsIgnoreCase("44869A")){
                int rowNbr=i+1;
                WebElement check = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + rowNbr + "]/td[1]"));
                check.click();
                break;
            }
        }
        driver.quit();

    }
}

package com.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
    public static void main(String[] args) {

        System.out.println("STARTED");

        try {

            WebDriverManager.chromedriver().setup();

            WebDriver driver = new ChromeDriver();

            driver.get("https://the-internet.herokuapp.com/login");

            Thread.sleep(2000);

            driver.findElement(By.id("username")).sendKeys("tomsmith");
            driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
            driver.findElement(By.cssSelector("button[type='submit']")).click();

            Thread.sleep(2000);

            String message = driver.findElement(By.id("flash")).getText();

            if(message.contains("You logged into a secure area")) {
                System.out.println("TEST PASSED");
            } else {
                System.out.println("TEST FAILED");
            }

            Thread.sleep(5000);

            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("ENDED");
    }
}
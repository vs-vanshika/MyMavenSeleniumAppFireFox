package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WindowType;

public class App {
    public static void main(String[] args) throws InterruptedException {

        // Start Firefox
        WebDriver driver = new FirefoxDriver();

        // =====================
        // SauceDemo login
        // =====================
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Thread.sleep(5000); // wait 5 sec before next site

        // =====================
        // Practice Test Automation login (new tab)
        // =====================
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        Thread.sleep(5000); // wait 5 sec before next site

        // =====================
        // Automation Exercise (new tab)
        // =====================
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://automationexercise.com");
        Thread.sleep(4000);

        // Click first "Add to Cart" button
        driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[1]")).click();
        Thread.sleep(4000);

        // Click Continue Shopping
        driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();

        System.out.println("All automations completed successfully.");

        // Close browser
        driver.quit();
    }
}

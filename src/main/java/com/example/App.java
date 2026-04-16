package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.WindowType;

import java.time.Duration;

public class App {
    public static void main(String[] args) {

        // Headless mode for Jenkins
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");

        WebDriver driver = new FirefoxDriver(options);

        // Better than Thread.sleep
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // =====================
            // SauceDemo login
            // =====================
            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();

            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            // =====================
            // Practice Test Automation login (new tab)
            // =====================
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://practicetestautomation.com/practice-test-login/");

            driver.findElement(By.id("username")).sendKeys("student");
            driver.findElement(By.id("password")).sendKeys("Password123");
            driver.findElement(By.id("submit")).click();

            // =====================
            // Automation Exercise (new tab)
            // =====================
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://automationexercise.com");

            driver.findElement(By.xpath("(//a[contains(text(),'Add to cart')])[1]")).click();
            driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")).click();

            System.out.println("All automations completed successfully.");

        } finally {
            // Always close browser
            driver.quit();
        }
    }
}

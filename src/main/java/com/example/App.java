package com.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class AppTest {

    @Test
    public void testAutomationFlow() {

        // Headless setup (REQUIRED for Jenkins)
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");

        WebDriver driver = new FirefoxDriver(options);

        // Implicit wait (replaces Thread.sleep)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {

            // =====================
            // SauceDemo login
            // =====================
            driver.get("https://www.saucedemo.com/");
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            // Assertion (VERY IMPORTANT)
            if (!driver.getCurrentUrl().contains("inventory")) {
                throw new RuntimeException("SauceDemo login failed");
            }

            // =====================
            // Practice Test Automation login
            // =====================
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://practicetestautomation.com/practice-test-login/");
            driver.findElement(By.id("username")).sendKeys("student");
            driver.findElement(By.id("password")).sendKeys("Password123");
            driver.findElement(By.id("submit")).click();

            if (!driver.getCurrentUrl().contains("logged-in")) {
                throw new RuntimeException("Practice site login failed");
            }

            // =====================
            // Automation Exercise
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

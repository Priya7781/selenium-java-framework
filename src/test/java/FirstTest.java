import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirstTest {

    @Test
    public void launchLoginPage() {

        // Chrome options for CI/CD
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        try {

            // Explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Open URL
            driver.get("https://priya7781.github.io/login-page/");

            // Verify URL contains login
            Assert.assertTrue(driver.getCurrentUrl().contains("login"));

            // Enter username
            driver.findElement(By.xpath("//input[@id='username']"))
                    .sendKeys("admin");

        
            

            // Enter password
            driver.findElement(By.xpath("//input[@id='password']"))
                    .sendKeys("1234");

            // Click login button
            driver.findElement(By.xpath("//button[@type='submit']"))
                    .click();

            // Wait for success message
            WebElement messageElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//p[@id='message']")
                    )
            );

            // Fetch text
            String actualMessage = messageElement.getText();

            System.out.println("Actual Message: " + actualMessage);
            

            // Assertion
            Assert.assertEquals(actualMessage, "Login Successful!");

        } finally {

            // Close browser
            driver.quit();
        }
    }
}
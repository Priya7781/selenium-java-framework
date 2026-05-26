import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {

    @Test
    public void launchLoginPage() {

        WebDriver driver = new ChromeDriver();

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

        // Fetch success message
        String actualMessage = driver.findElement(By.xpath("//p[@id='message']"))
                                     .getText();

        System.out.println("Actual Message: " + actualMessage);

        // Verify success message
        Assert.assertEquals(actualMessage, "Login Successful!");

        driver.quit();
    }
}



   
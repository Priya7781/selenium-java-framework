import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SecondTest {

    @Test
    public void launchUrl() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);
        try {
            String url = "https://www.google.com";
            driver.get(url);
            System.out.println("Launched URL: " + driver.getCurrentUrl());
            System.out.println("Page title: " + driver.getTitle());
        } finally {
            driver.quit();
        }
    }
}

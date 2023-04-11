package browserTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {
    static String browser = "firefox";
    static String baseUrl = "https://demo.nopcommerce.com/";
    static WebDriver driver;
    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        }else if (browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if (browser.equalsIgnoreCase("Edge")){
            driver = new EdgeDriver();
        }else {
            System.out.println("Wrong Browser Name");
        }
        // Open the URL in the Browser
        driver.get(baseUrl);

        // Get the title of the Page
        String title = driver.getTitle();

        // Printing the Title
        System.out.println(title);

        // Print the Page Source
        System.out.println("Page Source : " + driver.getPageSource());

        // We give Implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Find username field Element
        WebElement usernameField = driver.findElement(By.name("username"));

        // Type the username in the username field element
        usernameField.sendKeys("abcd1234@gmail.com");

        //Find Password field Element
        driver.findElement(By.name("password")).sendKeys("abc1234");

    }
}

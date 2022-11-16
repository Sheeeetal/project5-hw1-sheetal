import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest { static String browser = "edge";
    static String baseUrl = "https://courses.ultimateqa.com/users/sign_in";
    static WebDriver driver;

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gheko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();


        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }

        driver.get(baseUrl);
        // Maximise windows
        driver.manage().window().maximize();

        // Time implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        // Get the title of the page
        String title = driver.getTitle();
        System.out.println("Page title is :" + title);


        // get current URL
        System.out.println("Current URl :" + driver.getCurrentUrl());

        // Get page source
        System.out.println("Page source : " + driver.getPageSource());

        // Nevigate to login page
//        String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
//        driver.navigate().to(loginUrl);

        // Navigate to log in page by clicking on log in link
        // WebElement loginLink = driver.findElement(By.linkText("Log in"));
        // loginLink.click();

        // find the email field element
        // driver.findElement(By.id());
        WebElement emailField = driver.findElement(By.id("user[email]"));
        emailField.sendKeys("Sheetal@gmail.com");

        // Find the password field element
        //  driver.findElement(By.name(""));
        WebElement passwordField = driver.findElement(By.name("user[password]"));
        passwordField.sendKeys("Prime123");

        // Close the browser automatically
        // driver.close();
        //driver.quit();
        // driver.get("");

    }

}

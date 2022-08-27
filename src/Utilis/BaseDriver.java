package Utilis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseDriver {

    protected WebDriver driver; // protected because we need to use as a subclasses

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browser) {

        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\faruk\\OneDrive\\Masaüstü\\selenium-java-4.3.0\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("http://automationpractice.com");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        } else if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\faruk\\OneDrive\\Masaüstü\\geckodriver.exe");
            WebDriver driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("http://automationpractice.com");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        }


    }

    @AfterMethod
    public void tearDown() {

        driver.quit();

    }

}

package Test;

import POM.HomePageElements;
import POM.LoginPageElements;
import POM.MyAccountPageElements;
import Utilis.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class _01_LoginTest extends BaseDriver {



    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    MyAccountPageElements myAccountPageElements;

    @Test
    public void loginPositiveTest(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);

        WebElement element2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='login']")));

        homePageElements.loginButton.click();
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='email']")));
        loginPageElements.emailInput.sendKeys("qwerty@asdfgh.com");
        loginPageElements.passwordInput.sendKeys("789512358");
        loginPageElements.submitButton.click();
        WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Contact Us']")));

    }




}

package Test;

import POM.ContactUsPageElements;
import POM.HomePageElements;
import POM.LoginPageElements;
import POM.MyAccountPageElements;
import Utilis.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class _02_ContactUsTest extends BaseDriver {

    HomePageElements homePageElements;
    LoginPageElements loginPageElements;
    MyAccountPageElements myAccountPageElements;
    ContactUsPageElements contactUsPageElements;

    String expectedMessage = "Your message has been successfully sent to our team.";

    @Test
    @Parameters({"text1"})
    public void contactUs(String text1){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));

        homePageElements = new HomePageElements(driver);
        loginPageElements = new LoginPageElements(driver);
        myAccountPageElements = new MyAccountPageElements(driver);
        contactUsPageElements = new ContactUsPageElements(driver);

        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='login']")));

        homePageElements.loginButton.click();
        WebElement element1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='email']")));

        loginPageElements.emailInput.sendKeys("qwerty@asdfgh.com");
        loginPageElements.passwordInput.sendKeys("789512358");
        loginPageElements.submitButton.click();
        WebElement element2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Contact Us']")));

        myAccountPageElements.contactUsButton.click();
        WebElement element3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1[class='page-heading bottom-indent']")));

        Select selectSubject = new Select(contactUsPageElements.subjectHeading);
        selectSubject.selectByVisibleText("Customer service");

        contactUsPageElements.message.sendKeys(text1);
        contactUsPageElements.sendMessageButton.click();

        Assert.assertTrue(contactUsPageElements.contactUsSuccessMessage.isDisplayed());
        Assert.assertEquals(contactUsPageElements.contactUsSuccessMessage.getText(), expectedMessage);

    }
}

package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPageElements {

    public ContactUsPageElements(WebDriver driver){PageFactory.initElements(driver, this);}

    @FindBy(css = "h1[class='page-heading bottom-indent']")
    public WebElement contactUsHeader;

    @FindBy(css = "select[id='id_contact']")
    public WebElement subjectHeading;

    @FindBy(css = "textarea[id='message']")
    public WebElement message;

    @FindBy(css = "button[id='submitMessage']")
    public WebElement sendMessageButton;

    @FindBy(css = "p[class='alert alert-success']")
    public WebElement contactUsSuccessMessage;




}

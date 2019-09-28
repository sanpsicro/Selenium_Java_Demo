package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount extends BasePage{

    String url = "https://www.amazon.com";
    WebDriver driver;


    public CreateAccount(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }



    // Elements to create account

    @FindBy(xpath="//a[@tabindex='6'][contains(.,'Create your Amazon account')]")
    public WebElement BTN_createAccountButton;

    @FindBy(xpath="//input[@type='text'][contains(@id,'name')]")
    public WebElement TXT_yourName;

    @FindBy(xpath="//input[@type='email'][contains(@id,'email')]")
    public WebElement TXT_email;

    @FindBy(xpath="//input[@name='password']")
    public WebElement TXT_password;

    @FindBy(xpath="//input[@type='password'][contains(@id,'check')]")
    public WebElement TXT_repeatPwd;

    @FindBy(xpath="//h1[@class='a-spacing-small'][contains(.,'Create account')]")
    public WebElement CNT_createAccount;


    //-------------------------------------------------------


    public void open() {
        super.open(this.url, this.driver);
    }


    public void Click(WebElement we) {
        super.Click(we, this.driver);
    }


    public void SetText(WebElement we, String text) {
        super.SetText(we, text, this.driver);
    }


    public String getAttribute(WebElement we, String attribute) {
        return super.getAttribute(we, attribute, this.driver);
    }




}

package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;


public class HomePage  extends BasePage {

    String url = "https://www.amazon.com";
    WebDriver driver;


    public HomePage(WebDriver driver){

       this.driver = driver;
       PageFactory.initElements(driver, this);

    }




    // Identifiers for locate the Dom elements in Home Page
            @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
            public WebElement TXT_searchBox;

            @FindBy(xpath="//input[contains(@value,'Go')]" )
            public WebElement BTN_searchButton;

            @FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div[2]/div/span[3]/div[1]/div[1]/div/span/div/div/div[2]/div[2]/div/div[2]/div[1]/div/div[1]/div/div/a/span[1]/span[1]")
            public WebElement ATT_productPricetagMenu;

            @FindBy(xpath = "(//a[@class=\"a-link-normal a-text-normal\"])[1]")
            public WebElement LNK_firstresult;


            // when the product is in the cart

            @FindBy(xpath="//a[contains(.,'Your Amazon.com')]")
            public WebElement BTN_yourAmazonButton;




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

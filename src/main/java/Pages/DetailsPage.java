package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;


public class DetailsPage extends BasePage {

    String url = "https://www.amazon.com";
    WebDriver driver;



    public DetailsPage(WebDriver driver){
         this.driver =driver ;
        PageFactory.initElements(driver, this);

      }



    // Locators for the elements in this page -------------------
            @FindBy(xpath = "//span[@id='priceblock_ourprice']")
            public WebElement productPricetagDetails;

            @FindBy(xpath="//input[@name='submit.add-to-cart']")
            public WebElement addCart;

            @FindBy(xpath="//span[contains(@class,'nav-sprite nav-logo-base')]")
            public WebElement mainPageLogo;

    //-----------------------------------------------------------


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

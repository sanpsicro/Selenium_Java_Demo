import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Pages.*;

public class TC1_demoAmazon {


    public static WebDriver driver;

    // params for the windows handlers
    String homePageHandle;
    String detailsPageHandle;
    String createAccountHandle;

    // params for tag prices
    String pricetagMenu;
    String priceTagDetail;


    @BeforeClass
    void setUp(){

        driver = new FirefoxDriver();
        //FirefoxDriver.SystemProperty("");
        driver.manage().window().maximize();



    }

    @AfterClass
    void tearDown(){

        driver.quit();


    }


    /*
    Search Product

    In this step we cover the following actions from the exercise
    1.- Go to Amazon.com
    2.- Search for Samsung Galaxy S9 - store the price
    3.- Click on the First Result
    */

    @Test(testName ="Search product", priority = 0)
    void searchProduct(){

        //we initiate the corresponding class
        HomePage homePage = new HomePage(driver);

        //get the handle from the main window
        homePageHandle = driver.getWindowHandle();

        // Open the home page
        homePage.open();
        homePage.SetText(homePage.TXT_searchBox,"Samsung Galaxy S9");
        homePage.Click(homePage.BTN_searchButton);

        //we get the price showing in the price tag and store it

        pricetagMenu = homePage.getAttribute(homePage.ATT_productPricetagMenu ,"innerText");


        homePage.Click(homePage.LNK_firstresult);

        //get the handle for details window



    }

    @Test(priority = 1 , dependsOnMethods = {"searchProduct"})
    void comparePrices(){
        detailsPageHandle = driver.getWindowHandle();
        driver.switchTo().window(detailsPageHandle);

        //declare the instance for the new page
        DetailsPage detailPage = new DetailsPage(driver);

        priceTagDetail = detailPage.getAttribute(detailPage.productPricetagDetails,"innerText");

        Assert.assertEquals(pricetagMenu,priceTagDetail,"Compare tags");

        // click on the cart button

        detailPage.Click(detailPage.addCart);

        // go to Amazon web page

        detailPage.Click(detailPage.mainPageLogo);


    }

    @Test(priority = 2 , dependsOnMethods = {"comparePrices"})
    void createAccount(){

        // go to Amazon main page
        driver.switchTo().window(homePageHandle);
        HomePage homePage = new HomePage(driver);

        homePage.Click(homePage.BTN_yourAmazonButton);


        createAccountHandle = driver.getWindowHandle();
        driver.switchTo().window(createAccountHandle);
        CreateAccount createAccPage = new CreateAccount(driver);

        createAccPage.Click(createAccPage.BTN_createAccountButton);

        createAccPage.SetText(createAccPage.TXT_yourName, "testing robot");
        createAccPage.SetText(createAccPage.TXT_email, "robotMail@gmail.com");
        createAccPage.SetText(createAccPage.TXT_password, "mypwd");
        createAccPage.SetText(createAccPage.TXT_repeatPwd, "mypwd");

        String text_to_val = createAccPage.getAttribute(createAccPage.CNT_createAccount,"innerText");

        Assert.assertEquals(text_to_val,"Create account");




    }



}



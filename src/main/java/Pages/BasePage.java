package Pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import Interact.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;
import java.io.IOException;

public abstract class BasePage implements Actions{


    public BasePage(){

    }



    public void open(String url,WebDriver driver) {
        driver.get(url);
        captureScreenShot(driver);

    }




    public void Click(WebElement we,WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        we = wait.until(ExpectedConditions.elementToBeClickable(we));
        highlight(driver,we);
        captureScreenShot(driver);
        we.click();


    }

    public void SetText(WebElement we, String text,WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        we =  wait.until(ExpectedConditions.elementToBeClickable(we));
        we.sendKeys(text);
        highlight(driver,we);
        captureScreenShot(driver);

    }

    public String getAttribute(WebElement we, String attribute,WebDriver driver) {
        //WebDriverWait wait = new WebDriverWait(driver, 60);
       // we =  wait.until(ExpectedConditions.visibilityOf(we));

        String attribute_val = we.getAttribute(attribute);
        return attribute_val;
    }
    public static void captureScreenShot(WebDriver driver){

        // store the screenshot
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("/home/sanpsicro/Desktop/Prints/"+System.currentTimeMillis()+".png"));
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

    }

    private void highlight(WebDriver driver, WebElement we){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //use executeScript() method and pass the arguments
        //Here i pass values based on css style. Yellow background color with solid red color border.
        js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 2px solid red;');", we);

    }


}

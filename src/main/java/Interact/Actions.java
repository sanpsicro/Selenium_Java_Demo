package Interact;
import org.openqa.selenium.*;

public interface Actions {


    void Click(WebElement we, WebDriver driver);

    void SetText(WebElement we, String text,WebDriver driver);

    String getAttribute(WebElement we , String attribute,WebDriver driver);

    void open(String url,WebDriver driver);







}

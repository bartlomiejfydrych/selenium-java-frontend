package tools_qa.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class WebElementMethods {

    public boolean isElementPresent(WebElement webElement) {
        try{
            webElement.isDisplayed();
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    };
}

package HW_8_ShoppingTime.CustomExpectedConditions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class stalenessOfElement implements ExpectedCondition<Boolean> {
    public WebElement elementToDisappear;

    public stalenessOfElement(WebElement elementToDisappear) {
        this.elementToDisappear = elementToDisappear;
    }

    @Override
    public Boolean apply(WebDriver driver) {
        try {
            elementToDisappear.isDisplayed();
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }

    //Alternative solution here
    /*public String xpath;

    public stalenessOfElement(String xpath) {
            this.xpath = xpath;
        }

        try {
            driver.findElement(By.xpath(xpath));
            return false;
        } catch (NoSuchElementException e) {
            return true;
        }
    }*/

    }
}


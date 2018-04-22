package HW_8_ShoppingTime.CustomExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public class listNthElementHasText implements ExpectedCondition<Boolean> {
    public String listLocatorXpath;
    public int number;
    public String expectedText;

    public listNthElementHasText(String listLocatorXpath, int number, String expectedText) {
        this.listLocatorXpath = listLocatorXpath;
        this.number = number;
        this.expectedText = expectedText;
    }

    @Override
    public Boolean apply(WebDriver driver) {
        List<WebElement> list = driver.findElements(By.xpath(listLocatorXpath));
        try {
            return list.get(number).getText().contains(expectedText);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
            return false;
        }
    }
}


package HW_8_ShoppingTime.CustomExpectedConditions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class pageIsLoaded implements ExpectedCondition<Boolean> {
    public String expectedTitle;
    public String expectedUrl;

    public pageIsLoaded(String expectedTitle, String expectedUrl) {
        this.expectedTitle = expectedTitle;
        this.expectedUrl = expectedUrl;
    }

    @Override
    public Boolean apply(WebDriver driver) {
        Boolean isTitleCorrect = driver.getTitle().contains(expectedTitle);
        Boolean isUrlCorrect = driver.getCurrentUrl().contains(expectedUrl);
        return isTitleCorrect && isUrlCorrect;
    }
}

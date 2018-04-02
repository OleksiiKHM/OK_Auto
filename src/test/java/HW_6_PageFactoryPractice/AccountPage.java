package HW_6_PageFactoryPractice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    WebElement logoutButton;

    public void logout() {
        logoutButton.click();
    }
}

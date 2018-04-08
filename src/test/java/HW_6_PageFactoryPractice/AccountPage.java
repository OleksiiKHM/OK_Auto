package HW_6_PageFactoryPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    public WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    WebElement logoutButton;

    public LoginPage logout() {
        logoutButton.click();
        return new LoginPage(driver);
    }
}

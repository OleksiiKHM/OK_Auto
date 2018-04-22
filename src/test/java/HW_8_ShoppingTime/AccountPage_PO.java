package HW_8_ShoppingTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage_PO {

    public WebDriver driver;

    public AccountPage_PO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String url = "http://automationpractice.com/index.php?controller=my-account";
    public String title = "My account - My Store";

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    WebElement logoutButton;

    public LoginPage_PO logout() {
        logoutButton.click();
        return new LoginPage_PO(driver);
    }
}

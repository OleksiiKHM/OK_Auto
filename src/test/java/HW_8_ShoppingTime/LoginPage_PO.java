package HW_8_ShoppingTime;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PO {

    public WebDriver driver;

    public LoginPage_PO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    public String title = "Login - My Store";

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "passwd")
    WebElement passwdField;

    @FindBy(id = "SubmitLogin")
    WebElement submitButton;

    @FindBy(xpath = "//h1[@class=\"page-heading  product-listing\"]")
    WebElement productListing;

    public LoginPage_PO enterUserEmail(String userEmail) {
        emailField.sendKeys(userEmail);
        return this;
    }

    public LoginPage_PO enterPassword(String password) {
        passwdField.sendKeys(password);
        return this;
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public AccountPage_PO logIn(String userEmail, String password) {
        enterUserEmail(userEmail);
        enterPassword(password);
        clickSubmit();
        return new AccountPage_PO(driver);
    }


}

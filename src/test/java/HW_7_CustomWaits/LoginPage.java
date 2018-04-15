package HW_7_CustomWaits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public String loginPageUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    public String loginPageTitle = "Login - My Store";

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "passwd")
    WebElement passwdField;

    @FindBy(id = "SubmitLogin")
    WebElement submitButton;

    @FindBy(id = "search_query_top")
    WebElement searchField;

    @FindBy(xpath = "//h1[@class=\"page-heading  product-listing\"]")
    WebElement productListing;

    public LoginPage enterUserEmail(String userEmail) {
        emailField.sendKeys(userEmail);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwdField.sendKeys(password);
        return this;
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public AccountPage logIn(String userEmail, String password) {
        enterUserEmail(userEmail);
        enterPassword(password);
        clickSubmit();
        return new AccountPage(driver);
    }

    public void executeSearch(String query) {
        searchField.click();
        searchField.clear();
        searchField.sendKeys(query);
        searchField.submit();
    }

}

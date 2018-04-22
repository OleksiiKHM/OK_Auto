package HW_8_ShoppingTime;

        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;
        import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage_PO {

    public WebDriver driver;

    public BasePage_PO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search_query_top")
    WebElement searchField;

    @FindBy(xpath = "//a[@href='http://automationpractice.com/index.php?controller=my-account']")
    WebElement myAccountLink;

    @FindBy(xpath = "//a[@title='View my shopping cart']")
    WebElement cart;

    public void executeSearch(String query) {
        searchField.click();
        searchField.clear();
        searchField.sendKeys(query);
        searchField.submit();
    }

}

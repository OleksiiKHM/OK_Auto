package HW_7_CustomWaits;

import HW_7_CustomWaits.CustomExpectedConditions.pageIsLoaded;
import HW_7_CustomWaits.CustomExpectedConditions.listNthElementHasText;
import HW_7_CustomWaits.CustomExpectedConditions.stalenessOfElement;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccAndLoginTest {
    static WebDriver myDriver = new ChromeDriver();
    static LoginPage loginPage;
    static AccountPage accountPage;

    static String loginPageUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    static String loginPageTitle = "Login - My Store";

    WebDriverWait wait = new WebDriverWait(myDriver, 10);

    @BeforeClass
    public static void setUp() {
        myDriver.get(loginPageUrl);
        loginPage = new LoginPage(myDriver);
        accountPage = new AccountPage(myDriver);
    }

    @AfterClass
    public static void tearDown() {
        myDriver.quit();
    }

    @Test
    public void _3_pageIsLoadedConditionTest() {
        loginPage.executeSearch("Shirt");
        wait.until(new pageIsLoaded("Search - My Store", "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query"));
    }

    @Test
    public void _4_listNthElementHasTextConditionTest() {
        loginPage.executeSearch("Dress");
        wait.until(new listNthElementHasText("//a[@class='product-name']", 10, "Dress"));
    }

    @Test
    public void _5_stalenessOfElementConditionTest() {
        myDriver.navigate().to(loginPageUrl);
        wait.until(new pageIsLoaded(loginPageTitle, "http://automationpractice.com/index.php?controller=authentication&back=my-account"));
        wait.until(new stalenessOfElement(loginPage.productListing));
    }

}

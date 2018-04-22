package HW_8_ShoppingTime;

import HW_8_ShoppingTime.CustomExpectedConditions.listNthElementHasText;
import HW_8_ShoppingTime.CustomExpectedConditions.pageIsLoaded;
import HW_8_ShoppingTime.CustomExpectedConditions.stalenessOfElement;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccAndLoginTest {
    static WebDriver myDriver = new ChromeDriver();
    static LoginPage_PO loginPagePO;
    static AccountPage_PO accountPagePO;
    static BasePage_PO basePagePo;

    String emailInput = "hillbilly1969@yahoo.com";
    String passwdInput = "Amuricastrong";

    WebDriverWait wait = new WebDriverWait(myDriver, 10);

    @BeforeClass
    public static void setUp() {
        loginPagePO = new LoginPage_PO(myDriver);
        accountPagePO = new AccountPage_PO(myDriver);
        basePagePo = new BasePage_PO(myDriver);
        myDriver.get(loginPagePO.url);

    }

    @AfterClass
    public static void tearDown() {
        myDriver.quit();
    }


    @Ignore
    @Test
    public void _1_normalLogIn() {
        loginPagePO.logIn(emailInput, passwdInput);
        Assert.assertEquals(myDriver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=my-account");
    }

    @Ignore
    @Test
    public void _2_chainLogIn() {
        loginPagePO
                .enterUserEmail(emailInput)
                .enterPassword(passwdInput)
                .clickSubmit();
        Assert.assertEquals(myDriver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=my-account");
    }

    @Ignore
    @Test
    public void _3_logOut() {
        Assert.assertEquals(myDriver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=my-account");
        accountPagePO.logout();
        Assert.assertEquals(myDriver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @Test
    public void _3_pageIsLoadedConditionTest() {
        basePagePo.executeSearch("Shirt");
        wait.until(new pageIsLoaded("Search - My Store", "http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query"));
    }

    @Test
    public void _4_listNthElementHasTextConditionTest() {
        basePagePo.executeSearch("Dress");
        wait.until(new listNthElementHasText("//a[@class='product-name']", 10, "Dress"));
    }

    @Test
    public void _5_stalenessOfElementConditionTest() {
        myDriver.navigate().to(loginPagePO.url);
        wait.until(new pageIsLoaded(loginPagePO.title, "http://automationpractice.com/index.php?controller=authentication&back=my-account"));
        wait.until(new stalenessOfElement(loginPagePO.productListing));
    }

}

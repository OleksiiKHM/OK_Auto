package HW_6_PageFactoryPractice;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccAndLoginTest {
    static WebDriver myDriver = new ChromeDriver();
    static LoginPage loginPage;
    static AccountPage accountPage;
    String emailInput = "hillbilly1969@yahoo.com";
    String passwdInput = "Amuricastrong";

    @BeforeClass
    public static void setUp() {
        myDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        loginPage = new LoginPage(myDriver);
        accountPage = new AccountPage(myDriver);

    }

    @AfterClass
    public static void tearDown() {
        myDriver.quit();
    }

    @Ignore
    @Test
    public void _1_normalLogIn() {
        loginPage.logIn(emailInput, passwdInput);
        Assert.assertEquals(myDriver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=my-account");
    }

    @Test
    public void _2_chainLogIn() {
        loginPage
                .enterUserEmail(emailInput)
                .enterPassword(passwdInput)
                .clickSubmit();
        Assert.assertEquals(myDriver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=my-account");
    }


    @Test
    public void _3_logOut() {
        Assert.assertEquals(myDriver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=my-account");
        accountPage.logout();
        Assert.assertEquals(myDriver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }
}

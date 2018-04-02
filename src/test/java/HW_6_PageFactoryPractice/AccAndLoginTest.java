package HW_6_PageFactoryPractice;

import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

@FixMethodOrder(MethodSorters.JVM)
public class AccAndLoginTest {
    static WebDriver myDriver = new ChromeDriver();
    static LoginPage loginPage;
    static AccountPage accountPage;
    String emailInput = "hillbilly1969@yahoo.com";
    String passwdInput = "Amuricastrong";

    @BeforeClass
    public static void setUp() {
        myDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        loginPage = PageFactory.initElements(myDriver, LoginPage.class);
        accountPage = PageFactory.initElements(myDriver, AccountPage.class);
    }

    @AfterClass
    public static void tearDown(){
        myDriver.quit();
    }

    @Test
    public void normalLogIn() {
        loginPage.logIn(emailInput, passwdInput);
        Assert.assertEquals(myDriver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=my-account");
    }

    @Ignore
    @Test
    public void logOut() {
        Assert.assertEquals(myDriver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=my-account");
        accountPage.logout();
        Assert.assertEquals(myDriver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }
}

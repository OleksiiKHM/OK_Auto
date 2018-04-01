package AutomationPracticeStore;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    static WebDriver myDriver = new ChromeDriver();
    String userEmail = "hillbilly1969@yahoo.com";
    String userPasswd = "Amuricastrong";

    @BeforeClass
    public static void setUp() {
        myDriver.get("http://automationpractice.com/index.php");
        myDriver.manage().window().maximize();
    }

    @AfterClass
    public static void end() {
        myDriver.quit();
    }

    @Test
    public void loginTest() {
        myDriver.findElement(By.xpath("//a[@class='login']")).click();
        Assert.assertEquals(myDriver.getTitle(), "Login - My Store");

        myDriver.findElement(By.id("email")).sendKeys(userEmail);
        myDriver.findElement(By.id("passwd")).sendKeys(userPasswd);
        myDriver.findElement(By.id("SubmitLogin")).click();
        Assert.assertEquals(myDriver.getTitle(), "My account - My Store");
    }

    @Test
    public void myAccountLinksTest() {
        Assert.assertEquals(myDriver.getTitle(), "My account - My Store");

        myDriver.findElement(By.xpath("//a[@title='Orders']")).click();
        Assert.assertEquals(myDriver.getTitle(), "Order history - My Store");
        Assert.assertEquals(myDriver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=history");

        myDriver.navigate().back();
        Assert.assertEquals(myDriver.getTitle(), "My account - My Store");

        myDriver.findElement(By.xpath("//a[@title='Credit slips']")).click();
        Assert.assertEquals(myDriver.getTitle(), "Order slip - My Store");
        Assert.assertEquals(myDriver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=order-slip");

        myDriver.navigate().back();
        Assert.assertEquals(myDriver.getTitle(), "My account - My Store");

        myDriver.findElement(By.xpath("//a[@title='Addresses']")).click();
        Assert.assertEquals(myDriver.getTitle(), "Addresses - My Store");
        Assert.assertEquals(myDriver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=addresses");

        myDriver.navigate().back();
        Assert.assertEquals(myDriver.getTitle(), "My account - My Store");

        myDriver.findElement(By.xpath("//a[@title='Information']")).click();
        Assert.assertEquals(myDriver.getTitle(), "Identity - My Store");
        Assert.assertEquals(myDriver.getCurrentUrl(), "http://automationpractice.com/index.php?controller=identity");

        myDriver.navigate().back();
        Assert.assertEquals(myDriver.getTitle(), "My account - My Store");

        myDriver.findElement(By.xpath("//a[@title='My wishlists']")).click();
        Assert.assertEquals(myDriver.getTitle(), "My Store");
        Assert.assertEquals(myDriver.getCurrentUrl(), "http://automationpractice.com/index.php?fc=module&module=blockwishlist&controller=mywishlist");

    }

}

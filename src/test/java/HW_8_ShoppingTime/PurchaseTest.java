package HW_8_ShoppingTime;

import HW_8_ShoppingTime.CustomExpectedConditions.pageIsLoaded;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchaseTest {
    static WebDriver myDriver = new ChromeDriver();

    static LoginPage_PO loginPage;
    static AccountPage_PO accountPage;
    static BasePage_PO basePage;

    String emailInput = "hillbilly1969@yahoo.com";
    String passwdInput = "Amuricastrong";

    WebDriverWait wait = new WebDriverWait(myDriver, 5);

    @BeforeClass
    public static void setUp() {
        loginPage = new LoginPage_PO(myDriver);
        accountPage = new AccountPage_PO(myDriver);
        basePage = new BasePage_PO(myDriver);
        myDriver.get(loginPage.url);

    }

    /*@AfterClass
    public static void tearDown() {
        myDriver.quit();
    }
*/
    @Test
    public void purchaseFlowtest() {
        loginPage.logIn(emailInput, passwdInput);
        wait.until(new pageIsLoaded(accountPage.title, accountPage.url));

        basePage.executeSearch("Dress");
        wait.until(new pageIsLoaded("Search - My Store", "http://automationpractice.com/index.php?controller=search&orderby=position&orderway"));

        myDriver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[4]/div/div[2]/h5/a")).click();
        myDriver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button/span")).click();
        basePage.cart.click();

        wait.until(new pageIsLoaded("Order - My Store", "http://automationpractice.com/index.php?controller=order"));
        WebElement cartProduct = myDriver.findElement(By.xpath("//*[@id=\"product_7_34_0_57978\"]/td[2]/p/a"));
        Assert.assertEquals(cartProduct.getText(), "Printed Chiffon Dress");

        myDriver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
        wait.until(new pageIsLoaded("Order - My Store", "http://automationpractice.com/index.php?controller=order&step=1"));

        myDriver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button")).click();
        myDriver.findElement(By.xpath("//h1[contains(text(),'Shipping')]"));

        myDriver.findElement(By.xpath("//input[@type='checkbox']")).click();
        myDriver.findElement(By.xpath("//*[@id=\"form\"]/p/button/span")).click();

        WebElement purchasedProduct = myDriver.findElement(By.xpath("//p[@class='product-name']"));
        Assert.assertEquals(purchasedProduct.getText(), "Printed Chiffon Dress");

        WebElement payButton = myDriver.findElement(By.xpath("//a[@class='bankwire']"));
        payButton.click();

        WebElement confirmButton = myDriver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span"));
        confirmButton.click();

        basePage.myAccountLink.click();
        wait.until(new pageIsLoaded(accountPage.title, accountPage.url));
        myDriver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")).click();

        myDriver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr[1]/td[1]")).click();
        //myDriver.findElement(By.xpath("//*[@id=\"order-list\"]/tbody/tr[2]/td/div/div[3]/div[2]/a[1]/span")).click();

        String expectedProduct = wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[@id=\"order-detail-content\"]/table/tbody/tr/td[2]/label")))
                .getText();
        Assert.assertTrue(expectedProduct.contains("Printed Chiffon Dress"));
    }

}

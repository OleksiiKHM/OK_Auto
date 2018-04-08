package HW_5_AutomationPracticeStore;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {
    static WebDriver myDriver = new ChromeDriver();


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
    public void searchTest() {
        String query = "Printed Summer Dress";

        myDriver.findElement(By.id("search_query_top")).click();
        myDriver.findElement(By.id("search_query_top")).sendKeys(query);
        myDriver.findElement(By.id("search_query_top")).submit();

        Assert.assertEquals(myDriver.getTitle(), "Search - My Store");

        //strange way to verify that there are THREE search results, but it tests what is required
        WebElement threeItems = myDriver.findElement(By.xpath("//div[contains(text(),'Showing 1 - 3 of 3 items')]"));
        //verifying that first result equals specified query
        String firstResultText = myDriver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")).getText();
        Assert.assertEquals(firstResultText, query);

    }
}

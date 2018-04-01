/*
package FirstPackage;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class VeryFirstTest {
    static WebDriver myDriver = new ChromeDriver();

    @BeforeClass
    public static void setUp() {

        myDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        myDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        myDriver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

        myDriver.get("http://automationpractice.com/index.php");
        myDriver.manage().window().maximize();
    }

   */
/* @AfterClass
    public static void close() {
        myDriver.quit();
    }
*//*

    @Test
    public void theTest() {
        myDriver.findElement(By.id("search_query_top")).click();
        myDriver.findElement(By.id("search_query_top")).sendKeys("Pants");
        myDriver.findElement(By.id("search_query_top")).submit();
    }
}
*/

package HW_8_ShoppingTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class MyEventListener extends AbstractWebDriverEventListener {
    private static final Logger LOG = LogManager.getLogger(MyEventListener.class);

    public MyEventListener() {
        super();
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        LOG.error("Something went wrong! See this:" + throwable.getMessage());
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        LOG.info("Clicking on element: " + element.getText());
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        LOG.info("Navigating to: " + url);
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        LOG.info("Searching for element by locator: " + by);
    }


}

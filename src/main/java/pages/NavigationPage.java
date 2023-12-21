package pages;

import DriverPackage.DriverFactory;
import DriverPackage.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

import java.time.Duration;

public class NavigationPage {

    public NavigationPage() {
        PageFactory.initElements(DriverManager.getWebDriverManager().getWebDriver(), this);
    }

    private static final Logger logger = LogManager.getLogger(HomePage.class);

    public void openHomePage(){
        logger.info("open application url");
        DriverManager.getWebDriverManager().getWebDriver().get(ConfigReader.getConfigReader().getProperty("baseUrl"));
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriverManager().getWebDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState == 'complete';"));
    }

}

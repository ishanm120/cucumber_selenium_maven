package ui_framework.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui_framework.DriverPackage.DriverManager;
import utils.ConfigReader;

import java.time.Duration;

public class NavigationPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(NavigationPage.class);

    public NavigationPage() {
        driver = DriverManager.getWebDriverManager().getWebDriver();
        wait = new WebDriverWait(driver,
                Duration.ofSeconds(ConfigReader.getConfigReader().getGlobalWait()));
    }

    public void openHomePage() {
        openUrl(ConfigReader.getConfigReader().getApplicationUrl());
    }

    public void openLoginPage() {
        String baseUrl = ConfigReader.getConfigReader().getApplicationUrl();
        openUrl(baseUrl.replaceAll("/+$", "") + "/login");
    }

    private void openUrl(String url) {
        logger.info("Opening URL: {}", url);
        driver.get(url);
        wait.until(ExpectedConditions.jsReturnsValue(
                "return document.readyState === 'complete'"));
    }
}

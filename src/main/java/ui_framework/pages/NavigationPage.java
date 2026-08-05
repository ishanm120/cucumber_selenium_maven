package ui_framework.pages;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;

import java.time.Duration;

public class NavigationPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final Logger logger = LogManager.getLogger(NavigationPage.class);

    public NavigationPage() {
        driver = BaseTest.getDriver();
        wait = new WebDriverWait(driver,
                Duration.ofSeconds(ConfigReader.getInstance().getGlobalTimeout()));
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        openUrl(ConfigReader.getInstance().getApplicationUrl());
    }

    public void openLoginPage() {
        String baseUrl = ConfigReader.getInstance().getApplicationUrl();
        openUrl(baseUrl.replaceAll("/+$", "") + "/login");
    }

    private void openUrl(String url) {
        logger.info("Opening URL: {}", url);
        driver.get(url);
        wait.until(ExpectedConditions.jsReturnsValue(
                "return document.readyState === 'complete'"));
    }
}

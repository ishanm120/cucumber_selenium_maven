package ui_framework.DriverPackage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;

import java.time.Duration;

public class DriverFactory {
    public final static int TIMEOUT = 10;

    private static final Logger logger = LogManager.getLogger(DriverFactory.class);

    protected static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();


    protected boolean isWebDriverStopped() {
        return driverThreadLocal.get() == null;
    }

    public void startWebDriver() {
        if (isWebDriverStopped()) {
                logger.info("Create web driver instance!");
                try {
                    driverThreadLocal.set(getDriverInstance());
                    driverThreadLocal.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
                    driverThreadLocal.get().manage().window().maximize();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
        }
    }

    public WebDriver getWebDriver() {
        try {
            return driverThreadLocal.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T extends WebDriver> T getWebDriver(Class<T> clazz) throws Exception {
        if (isWebDriverStopped()) {
            throw new IllegalStateException("WebDriver has not been started for this thread");
        }
        if (clazz.isInstance(driverThreadLocal.get())) {
            return clazz.cast(driverThreadLocal.get());
        } else {
            return null;
        }
    }

    public void stopWebDriver(boolean isClose) {
        if (isWebDriverStopped()) {
            return;
        }
        try {
            getWebDriver().quit();
        } finally {
            driverThreadLocal.remove();
        }
    }

    public WebDriver getDriverInstance(){
        String browser = ConfigReader.getConfigReader().getProperty("browser");
        logger.info("browser name is : {}", browser);
        return getDriverInstance(browser);
    }

    public WebDriver getDriverInstance(String browser){
        switch (browser){
            case "chrome":
                return getChromeDriverInstance();
            case "firefox":
                return getFireFoxDriverInstance();
        }
        throw new IllegalArgumentException("Unsupported browser: " + browser);
    }

    private WebDriver getChromeDriverInstance(){
        ChromeOptions options = new ChromeOptions();
        String browserVersion = ConfigReader.getConfigReader().getProperty("browserVersion");
        if (browserVersion != null && !browserVersion.isBlank()) {
            options.setBrowserVersion(browserVersion);
        }
        if (Boolean.parseBoolean(ConfigReader.getConfigReader().getProperty("headless"))) {
            options.addArguments("--headless=new", "--window-size=1920,1200", "--no-sandbox", "--disable-dev-shm-usage");
        }
        return new ChromeDriver(options);
    }

    private WebDriver getFireFoxDriverInstance(){
        return new FirefoxDriver();
    }


}

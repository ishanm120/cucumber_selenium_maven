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

    protected static
    ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();



    protected boolean isWebDriverStarted() {
        return driverThreadLocal.get() != null;
    }

    public void startWebDriver() {
        if (!isWebDriverStarted()) {
            synchronized (Thread.currentThread()) {
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
    }

    public WebDriver getWebDriver() {
        try {
            return driverThreadLocal.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T extends WebDriver> T getWebDriver(Class<T> clazz) throws Exception {
        if (!isWebDriverStarted()) {
            throw new Exception();
        }
        if (clazz.isInstance(driverThreadLocal.get())) {
            return clazz.cast(driverThreadLocal.get());
        } else {
            return null;
        }
    }

    public void stopWebDriver(boolean isClose) {
        if (!isWebDriverStarted()) {
            return;
        }
        getWebDriver().quit();
        driverThreadLocal.set(null);
    }

    public WebDriver getDriverInstance(){
        String browser = ConfigReader.getConfigReader().getProperty("browser");
        logger.info("browser name is : ");
        System.out.println("browser name is : "+ browser);
        return getDriverInstance(browser);
    }

    public WebDriver getDriverInstance(String browser){
        switch (browser){
            case "chrome":
                return getChromeDriverInstance();
            case "firefox":
                return getFireFoxDriverInstance();
        }
        return null;
    }

    private WebDriver getChromeDriverInstance(){
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion(ConfigReader.getConfigReader().getProperty("browserVersion"));
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    private WebDriver getFireFoxDriverInstance(){
        WebDriver driver = new FirefoxDriver();
        return driver;
    }


}

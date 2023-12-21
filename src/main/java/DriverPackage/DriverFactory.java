package DriverPackage;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;
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


















//
//
//    public static WebDriver getDriver() {
//        return driver;
//    }
//
//    public static void setUpDriver() {
//
//        if (driverFactory==null) {
//            driverFactory = new DriverFactory();
//        }
//    }
//
//    public static void tearDown(Scenario scenario) {
//
//        if(scenario.isFailed()) {
//            final byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image.png", scenario.getName());
//        }
//        if(driver!=null) {
//            driver.close();
//            driver.quit();
//        }
//        driverFactory = null;
//    }
//
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
        }
        return null;
    }

    private WebDriver getChromeDriverInstance(){
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("117");
        WebDriver driver = new ChromeDriver();
        return driver;
    }


}

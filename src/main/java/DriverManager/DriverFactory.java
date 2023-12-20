package DriverManager;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import utils.ConfigReader;

import java.time.Duration;

public class DriverFactory {

    private static DriverFactory driverFactory;
    private static WebDriver driver ;
    public final static int TIMEOUT = 2;

    private static final Logger logger = LogManager.getLogger(HomePage.class);

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver() {

        if (driverFactory==null) {
            driverFactory = new DriverFactory();
        }
    }

    public static void tearDown(Scenario scenario) {

        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image.png", scenario.getName());
        }
        if(driver!=null) {
            driver.close();
            driver.quit();
        }
        driverFactory = null;
    }

    public static WebDriver getDriverInstance(){
        String browser = ConfigReader.getConfigReader().getProperty("browser");
        logger.info("browser name is : ");
        System.out.println("browser name is : "+ browser);
        driver = getDriverInstance(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriverInstance(String browser){
        driver = null;
        switch (browser){
            case "chrome":
                driver = getChromeDriverInstance();
        }
        return driver;
    }

    private static WebDriver getChromeDriverInstance(){
        ChromeOptions options = new ChromeOptions();
        options.setBrowserVersion("117");
         driver = new ChromeDriver();
        return driver;
    }


}

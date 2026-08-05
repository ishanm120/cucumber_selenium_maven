package stepDefs;

import ui_framework.DriverPackage.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {
    private static final ThreadLocal<Logger> logger = ThreadLocal.withInitial(() -> LogManager.getLogger(Thread.currentThread().getName()));

    private static Logger getLogger() {
        return logger.get();
    }

    @Before
    public void setup(Scenario scenario) {
        if (scenario.getSourceTagNames().contains("@ui")) {
            getLogger().info("starting webdriver instance");
            DriverManager.getWebDriverManager().startWebDriver();
        } else {
            getLogger().info("API test started {}", scenario.getName());
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        afterStep(scenario);
        if (scenario.getSourceTagNames().contains("@ui")) {
            getLogger().info("stopping webdriver instance");
            DriverManager.getWebDriverManager().stopWebDriver(true);
        }
    }

    private void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] src = ((TakesScreenshot) DriverManager.getWebDriverManager().getWebDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(src, "image/png", null);
            } catch (Exception e) {
            }
        }
    }

}

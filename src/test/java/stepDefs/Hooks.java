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

    @Before("@ui")
    public void setup(Scenario scenario) {
        getLogger().info("UI test started: {}", scenario.getName());
        DriverManager.getWebDriverManager().startWebDriver();
    }

    @After("@ui")
    public void tearDown(Scenario scenario) {
        try {
            attachScreenshotOnFailure(scenario);
        } finally {
            DriverManager.getWebDriverManager().stopWebDriver(true);
            logger.remove();
        }
    }

    private void attachScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] src = ((TakesScreenshot) DriverManager.getWebDriverManager().getWebDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(src, "image/png", "Failure screenshot");
            } catch (Exception e) {
                getLogger().warn("Unable to attach failure screenshot", e);
            }
        }
    }

}

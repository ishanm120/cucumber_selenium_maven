package stepDefs;

import org.junit.Assume;
import ui_framework.DriverPackage.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.CommonConstants;


public class Hooks {
    private static final ThreadLocal<Logger> logger = ThreadLocal.withInitial(() -> LogManager.getLogger(Thread.currentThread().getName()));

    private static Logger getLogger() {
        return logger.get();
    }

    @Before
    public void setup(Scenario scenario) {
        getLogger().error("API test started " + scenario.getName());
        if (scenario.getSourceTagNames().contains("@ui")) {
            getLogger().info("starting webdriver instance");
            DriverManager.getWebDriverManager().startWebDriver();
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        afterStep(scenario);
        DriverManager.getWebDriverManager().stopWebDriver(true);
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
    @After(value = "@dependsOn", order = 0)
    public void setDependsFlag(Scenario scenario) {
        System.out.println("scenario status is " + scenario.getStatus());
        if (scenario.getStatus().toString().equals("PASSED")) {
            if (scenario.getSourceTagNames().contains("@loginDepends")) {
                System.out.println("setting login flag value to true");
                CommonConstants.skip_dependsOnLogin = false;
            } else if (scenario.getSourceTagNames().contains("@searchDepends")) {
                System.out.println("setting search flag value to true");
                CommonConstants.skip_dependsOnSearch = false;
            }
        }
    }

    @Before(value = "@dependent", order = 0)
    public void checkDependsFlag(Scenario scenario) {
        System.out.println("checking dependent flag before running dependent tests");
        if (scenario.getSourceTagNames().contains("@loginDepends") && CommonConstants.skip_dependsOnLogin) {
            System.out.println("skip the scenario " + scenario.getName());
            Assume.assumeTrue(false);
        } else if (scenario.getSourceTagNames().contains("@searchDepends") && CommonConstants.skip_dependsOnSearch) {
            System.out.println("skip the scenario " + scenario.getName());
            Assume.assumeTrue(false);
        }
    }
}

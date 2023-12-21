package stepDefs;

import DriverPackage.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {
    private static final ThreadLocal<Logger> logger = ThreadLocal.withInitial(() -> LogManager.getLogger(Thread.currentThread().getName()));
   private static Logger getLogger(){
       return logger.get();
   }

    @Before
    public void setup(){

        getLogger().info("Test Case Start");
        DriverManager.getWebDriverManager().startWebDriver();
    }

    @After
    public void tearDown(Scenario scenario){
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

}

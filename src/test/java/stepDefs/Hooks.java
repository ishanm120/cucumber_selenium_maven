package stepDefs;

import DriverPackage.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {

    @Before
    public void setup(){
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

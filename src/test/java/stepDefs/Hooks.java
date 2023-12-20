package stepDefs;
import org.openqa.selenium.OutputType;
import DriverManager.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setup(){
        DriverFactory.getDriverInstance();
    }

    @After
    public void tearDown(Scenario scenario){
        DriverFactory.tearDown(scenario);
    }
}

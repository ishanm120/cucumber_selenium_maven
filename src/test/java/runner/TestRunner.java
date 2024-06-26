package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import utils.ConfigReader;


@CucumberOptions(features = "src/test/resources/features",
        glue = {"stepDefs"},
        plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@api",
        monochrome = true,
        publish = false)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass(alwaysRun = true)
    @Override
    public void setUpClass(ITestContext context) {
        context.getCurrentXmlTest().getSuite().setDataProviderThreadCount(Integer.valueOf(ConfigReader.getConfigReader().getProperty("threadCount")));
        context.getCurrentXmlTest().getSuite().setPreserveOrder(false);
        super.setUpClass(context);
    }

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

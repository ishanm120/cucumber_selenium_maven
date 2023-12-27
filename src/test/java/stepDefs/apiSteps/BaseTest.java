package stepDefs.apiSteps;

import api_framework.api.ServerStepsProvider;
import api_framework.api.ServiceProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.asserts.SoftAssert;

import java.util.Collections;
import java.util.Map;

public class BaseTest {

    protected ServiceProvider serviceProvider = new ServiceProvider();
    protected ServerStepsProvider serverStepsProvider = new ServerStepsProvider();

    protected Map<String, String> userHeader = Collections.singletonMap("userId","3332656");
    protected ObjectMapper mapper = new ObjectMapper();
    protected SoftAssert softAssert = new SoftAssert();
}

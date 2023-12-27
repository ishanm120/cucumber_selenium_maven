package stepDefs.apiSteps;

import api_framework.api.AssertableResponse;
import api_framework.objects.responsePOJO.FacilityDetails;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.testng.asserts.SoftAssert;

public class facilityServiceSteps extends BaseTest{
 private AssertableResponse response;


    @When("user hits GET facility details service for facility {string}")
    public AssertableResponse getResponseOfPostCreateUserRequest(String facility) throws JsonProcessingException {
        response = serverStepsProvider.getGatewayVerificationServerSteps().getFacilityDetails(facility, userHeader);
    return response;
    }

    @Then("validate response of facility")
    public void verifyFacilityResponse(){
        response.validateStatusResponse(HttpStatus.SC_OK);
        FacilityDetails facilityDetails = response.responseAs(FacilityDetails.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(facilityDetails.getFacilityId(), "6124");
        softAssert.assertEquals(facilityDetails.getFacilityName(), "TEST");
        softAssert.assertAll();
    }
}

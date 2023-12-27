package api_framework.serverSteps;

import api_framework.api.AssertableResponse;
import api_framework.services.base.HttpMethods;

import java.util.Map;

public class GatewayVerificationServerSteps extends HttpMethods {

    public AssertableResponse getFacilityDetails(String facilityId, Map<String,String> headers){
        return serviceProvider.getGatewayVerificationService().getFacilityDetails(facilityId,headers);
    }
}

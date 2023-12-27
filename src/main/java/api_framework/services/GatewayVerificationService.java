package api_framework.services;

import api_framework.api.AssertableResponse;
import api_framework.services.base.HttpMethods;

import java.util.Map;

/**
 * This class will contain all service calls in origin gateway
 */
public class GatewayVerificationService extends HttpMethods {

    public static final String FACILITY_ROUTE = "/facility/";

    public AssertableResponse getFacilityDetails(String facilityId, Map<String , String> headers){
        return new AssertableResponse(getMethod(eManifestInstance, FACILITY_ROUTE+facilityId,headers));
    }
}

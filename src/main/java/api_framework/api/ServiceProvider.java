package api_framework.api;

import api_framework.services.GatewayVerificationService;

import static java.util.Objects.isNull;

/**
 * This class will return objects of all service classes
 */
public class ServiceProvider {

    private GatewayVerificationService gatewayVerificationService;

    public GatewayVerificationService getGatewayVerificationService(){
        return isNull(gatewayVerificationService) ? gatewayVerificationService = new GatewayVerificationService() : gatewayVerificationService;
    }
}

package api_framework.api;

import api_framework.serverSteps.GatewayVerificationServerSteps;

import static java.util.Objects.isNull;

/**
 * This class will return objects of all server step classes
 */
public class ServerStepsProvider {

    private GatewayVerificationServerSteps gatewayVerificationServerSteps;

    public GatewayVerificationServerSteps getGatewayVerificationServerSteps(){
        return isNull(gatewayVerificationServerSteps) ? gatewayVerificationServerSteps = new GatewayVerificationServerSteps() : gatewayVerificationServerSteps;
    }
}

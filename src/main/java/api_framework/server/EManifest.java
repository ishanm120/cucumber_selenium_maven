package api_framework.server;

import io.restassured.response.Response;
import utils.ConfigReader;

public class EManifest implements Server{

    private static EManifest emanifestInstance = null;

    private Response response;

    public static EManifest getInstance(){
        if(emanifestInstance==null){
            emanifestInstance = new EManifest();
        }
        return emanifestInstance;
    }
    @Override
    public void getResponse(Response response) {

    }

    @Override
    public Response getResponse() {
        return null;
    }

    @Override
    public String getApiBaseUrl() {
        return ConfigReader.getConfigReader().getProperty("apiBaseUrl");
    }
}

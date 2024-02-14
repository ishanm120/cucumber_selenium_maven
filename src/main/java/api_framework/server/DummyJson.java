package api_framework.server;

import io.restassured.response.Response;
import utils.ConfigReader;

public class DummyJson implements Server{

    private static DummyJson dummyJson = null;

    private Response response;

    public static DummyJson getInstance(){
        if(dummyJson==null){
            dummyJson = new DummyJson();
        }
        return dummyJson;
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

package api_framework.server;

import io.restassured.response.Response;

public interface Server {

    void getResponse(Response response);

    Response getResponse();

    String getApiBaseUrl();
}

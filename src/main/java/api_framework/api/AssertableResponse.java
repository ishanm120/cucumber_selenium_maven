package api_framework.api;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import org.testng.Assert;

@AllArgsConstructor
public class AssertableResponse {

    private Response response;

    public <T> T responseAs(Class<T> tClass){
        return response.as(tClass);
    }

    public Response getResponse(){
        return  response;
    }

    public AssertableResponse validateStatusResponse(int statusCode){
        response.then().assertThat().statusCode(statusCode);
        return this;
    }

    public AssertableResponse validateEmptyBody(){
        String jsonAsString = response.getBody().asString();
        Assert.assertTrue(jsonAsString.isEmpty());
        return this;
    }

}

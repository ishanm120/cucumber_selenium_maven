package stepDefs.apiSteps;

import api_framework.api.AssertableResponse;
import api_framework.objects.requestsPOJO.CreateProductRequest;
import api_framework.objects.responsePOJO.GetProductResponse;
import api_framework.objects.responsePOJO.GetProductsResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonObject;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class productServiceSteps extends BaseTest{
 private AssertableResponse response;

    @When("user hits GET products details service")
    public AssertableResponse getResponseOfProducts()  {
        response = serverStepsProvider.getProductsServerSteps().getProducts(userHeader);
        return response;
    }

    @When("user hits GET product by id service with product id {string}")
    public AssertableResponse getResponseOfSingleProduct(String productId)  {
        response = serverStepsProvider.getProductsServerSteps().getSingleProduct(productId, userHeader);
        return response;
    }

    @When("user hits POST add product service with following information:")
    public AssertableResponse getResponseOfSAddProduct(DataTable dataTable) throws JsonProcessingException {
        Map<String, String> rows = dataTable.asMap(String.class,String.class);
        CreateProductRequest createProductRequest = new CreateProductRequest();
        createProductRequest.setTitle(rows.get("title"));
        createProductRequest.setDescription(rows.get("description"));
        createProductRequest.setBrand(rows.get("brand"));
        createProductRequest.setCategory(rows.get("category"));
        createProductRequest.setPrice(rows.get("price"));
        response = serverStepsProvider.getProductsServerSteps().addNewProduct(createProductRequest,userHeader);
        return response;
    }

    @When("user hits update product by id service with product id {string}")
    public AssertableResponse getResponseOfUpdateProduct(String productId, DataTable dataTable) throws JsonProcessingException {
        Map<String, String> rows = dataTable.asMap(String.class,String.class);
        JsonObject jsonObject = new JsonObject();
        for(Map.Entry<String, String> enterySet: rows.entrySet()) {
            jsonObject.addProperty(enterySet.getKey(), enterySet.getValue());
        }
        response = serverStepsProvider.getProductsServerSteps().updateSingleProduct(jsonObject.toString(), productId, userHeader);
        return response;
    }

    @Then("verify product is {word} successfully with title {string}")
    public void verifyProductSuccessfully(String operation, String productTitle){
        int expectedStatus = "added".equals(operation) ? HttpStatus.SC_CREATED : HttpStatus.SC_OK;
        response.validateStatusResponse(expectedStatus);
        GetProductResponse getProductResponse = response.responseAs(GetProductResponse.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(getProductResponse.getId() > 0, "id is not created");
        softAssert.assertEquals(getProductResponse.getTitle(),productTitle, "title not matching");
        softAssert.assertAll();
    }

    @Then("validate response of products")
    public void verifyFacilityResponse(){
        response.validateStatusResponse(HttpStatus.SC_OK);
        GetProductsResponse getProductsResponse = response.responseAs(GetProductsResponse.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Integer.parseInt(getProductsResponse.getTotal()) > 0, "product total should be positive");
        softAssert.assertFalse(getProductsResponse.getGetProductResponses().isEmpty(), "products should not be empty");
        softAssert.assertAll();
    }

    @Then("user should see {string} products")
    public void verifyFacilityResponse(String productCount){
        response.validateStatusResponse(HttpStatus.SC_OK);
        GetProductsResponse getProductsResponse = response.responseAs(GetProductsResponse.class);
        Assert.assertEquals(getProductsResponse.getTotal(), productCount);
    }

    @Then("user should see available products")
    public void verifyProductsAreAvailable(){
        response.validateStatusResponse(HttpStatus.SC_OK);
        GetProductsResponse getProductsResponse = response.responseAs(GetProductsResponse.class);
        Assert.assertTrue(Integer.parseInt(getProductsResponse.getTotal()) > 0, "product total should be positive");
        Assert.assertFalse(getProductsResponse.getGetProductResponses().isEmpty(), "products should not be empty");
    }

    @Then("user should following information for product with id {string}:")
    public void verifyFacilityResponse(String productId, DataTable dataTable){
        Map<String, String> rows = dataTable.asMap(String.class,String.class);
        response.validateStatusResponse(HttpStatus.SC_OK);
        GetProductResponse getProductResponse = response.responseAs(GetProductResponse.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(getProductResponse.getId(), Integer.parseInt(productId), "id is not correct");
        softAssert.assertEquals(getProductResponse.getTitle(), rows.get("title"), "title is not correct");
        softAssert.assertEquals(getProductResponse.getDescription(), rows.get("description"), "description is wrong");
        softAssert.assertEquals(getProductResponse.getPrice(), Double.parseDouble(rows.get("price")), "price is not matching");
        softAssert.assertEquals(getProductResponse.getBrand(), rows.get("brand"),"brand is not matching");
        softAssert.assertEquals(getProductResponse.getCategory(), rows.get("category"), "category not matching");
        softAssert.assertAll();
    }
}

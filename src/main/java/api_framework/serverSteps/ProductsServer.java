package api_framework.serverSteps;

import api_framework.api.AssertableResponse;
import api_framework.objects.requestsPOJO.CreateProductRequest;
import api_framework.services.base.HttpMethods;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;

public class ProductsServer extends HttpMethods {

    public AssertableResponse getProducts(Map<String,String> headers){
        return serviceProvider.getProductsService().getProducts(headers);
    }

    public AssertableResponse getSingleProduct(String productId, Map<String,String> headers){
        return serviceProvider.getProductsService().getSingleProduct(productId, headers);
    }

    public AssertableResponse addNewProduct(CreateProductRequest createProductRequest, Map<String,String> headers) throws JsonProcessingException {
        return serviceProvider.getProductsService().addNewProduct(createProductRequest, headers);
    }

    public AssertableResponse updateSingleProduct(String payload,String productId, Map<String,String> headers) throws JsonProcessingException {
        return serviceProvider.getProductsService().updateSingleProduct(payload,productId, headers);
    }
}

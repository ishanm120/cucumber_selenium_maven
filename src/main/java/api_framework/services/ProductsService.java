package api_framework.services;

import api_framework.api.AssertableResponse;
import api_framework.objects.requestsPOJO.CreateProductRequest;
import api_framework.services.base.HttpMethods;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;

/**
 * This class will contain all service calls in origin gateway
 */
public class ProductsService extends HttpMethods {

    public static final String GET_PRODUCTS = "/products";
    public static final String GET_SINGLE_PRODUCT = "/products/%s";
    public static final String ADD_PRODUCT = "/products/add";

    public AssertableResponse getProducts(Map<String , String> headers){
        return new AssertableResponse(getMethod(dummyJson_instance, GET_PRODUCTS,headers));
    }
    public AssertableResponse getSingleProduct(String productId, Map<String , String> headers){
        return new AssertableResponse(getMethod(dummyJson_instance, String.format(GET_SINGLE_PRODUCT,productId),headers));
    }
    public AssertableResponse addNewProduct(CreateProductRequest createProductRequest, Map<String , String> headers) throws JsonProcessingException {
        return new AssertableResponse(POST_METHOD(dummyJson_instance, ADD_PRODUCT ,headers, mapper.writeValueAsString(createProductRequest)));
    }

    public AssertableResponse updateSingleProduct(String payload,String productId, Map<String , String> headers) {
        return new AssertableResponse(PUT_METHOD(dummyJson_instance, String.format(GET_SINGLE_PRODUCT,productId) ,headers, payload));
    }
}

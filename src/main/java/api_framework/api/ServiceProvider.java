package api_framework.api;

import api_framework.services.ProductsService;
import static java.util.Objects.isNull;

/**
 * This class will return objects of all service classes
 */
public class ServiceProvider {
    private ProductsService productsService;

    public ProductsService getProductsService(){
        return isNull(productsService) ? productsService = new ProductsService() : productsService;
    }
}

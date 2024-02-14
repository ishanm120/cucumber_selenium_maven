package api_framework.api;
import api_framework.serverSteps.ProductsServer;
import static java.util.Objects.isNull;

/**
 * This class will return objects of all server step classes
 */
public class ServerStepsProvider {

    private ProductsServer productsServer;

    public ProductsServer getProductsServerSteps(){
        return isNull(productsServer) ? productsServer = new ProductsServer() : productsServer;
    }
}

package api_framework.services.base;

import api_framework.api.ServiceProvider;
import api_framework.server.DummyJson;
import api_framework.server.Server;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;

import static io.restassured.http.ContentType.JSON;

public class BaseService {

    protected ServiceProvider serviceProvider = new ServiceProvider();

	protected DummyJson dummyJson_instance = DummyJson.getInstance();

	protected ObjectWriter mapper = new ObjectMapper().writer().withDefaultPrettyPrinter();

   protected RequestSpecification setUpBaseConnection(Server server){
	   return getRequestSpecification(ConfigReader.getConfigReader().getProperty("apiBaseUrl"));
   }

	protected RequestSpecification getRequestSpecification(String apiBaseUrl){
		return RestAssured.given().baseUri(apiBaseUrl)
				.relaxedHTTPSValidation()
				.contentType(JSON);
	}

}

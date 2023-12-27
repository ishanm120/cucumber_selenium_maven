package api_framework.services.base;

import api_framework.api.ServiceProvider;
import api_framework.server.EManifest;
import api_framework.server.Server;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;

import static io.restassured.http.ContentType.JSON;

public class BaseService {

    protected ServiceProvider serviceProvider = new ServiceProvider();

	protected EManifest eManifestInstance = EManifest.getInstance();

   protected RequestSpecification setUpBaseConnection(Server server){
	   return getRequestSpecification(ConfigReader.getConfigReader().getProperty("apiBaseUrl"));
   }

	protected RequestSpecification getRequestSpecification(String apiBaseUrl){
		return RestAssured.given().baseUri(apiBaseUrl)
				.relaxedHTTPSValidation()
				.contentType(JSON);
	}

}

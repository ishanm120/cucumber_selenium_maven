package api_framework.services.base;

import api_framework.server.Server;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import java.util.Collections;
import java.util.Map;

public class HttpMethods extends BaseService {

    protected Response GET_METHOD(Server server, String route, Map<String, String> headers, Map<String, String> params){
        return setUpBaseConnection(server)
                .header("Content-Type", "application/json")
                .headers(headers != null ? headers : Collections.EMPTY_MAP)
                .params(params != null ? params : Collections.EMPTY_MAP)
                .log()
                .all()
                .when()
                .get(route)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    public Response getMethod(Server server, String route, Map<String, String> headers){
        return GET_METHOD(server,route,headers, null);
    }

    protected Response POST_METHOD(Server server, String route, Map<String, String> headers, String body){
        return setUpBaseConnection(server)
                .header("Content-Type", "application/json")
                .headers(headers != null ? headers : Collections.EMPTY_MAP)
                .body(body != null ? body : StringUtils.EMPTY)
                .log()
                .all()
                .when()
                .post(route)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    protected Response PUT_METHOD(Server server, String route, Map<String, String> headers, String body){
        return setUpBaseConnection(server)
                .header("Content-Type", "application/json")
                .headers(headers != null ? headers : Collections.EMPTY_MAP)
                .body(body != null ? body : StringUtils.EMPTY)
                .log()
                .all()
                .when()
                .put(route)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    protected Response DELETE_METHOD(Server server, String route, Map<String, String> headers, String body){
        return setUpBaseConnection(server)
                .header("Content-Type", "application/json")
                .headers(headers != null ? headers : Collections.EMPTY_MAP)
                .body(body != null ? body : StringUtils.EMPTY)
                .log()
                .all()
                .when()
                .delete(route)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }
}

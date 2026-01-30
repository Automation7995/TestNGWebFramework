package tests;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import utils.ConfigReader;

public class RestAssured {

    public void getStatusCode() {
        given().baseUri(ConfigReader.getProperty("url"))
        .when().get("/api/users/2")
        .then().statusCode(200);
    } 

    public void postStatusCode() {
        Map<String, String> responseBody = new HashMap<>();
        responseBody.put("Name", "Rahul");
        responseBody.put("Address", "Pune");

        given().baseUri(ConfigReader.getProperty("url")).contentType("application/json").body(responseBody)
        .when().post(DEFAULT_BODY_ROOT_PATH, responseBody);
    }
}

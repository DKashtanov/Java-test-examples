package utils.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiUtils {

    public static Response doGet(String url) {
        return given()
                .when()
                .contentType(ContentType.JSON)
                .get(url)
                .then()
                .extract()
                .response();
    }

    public static Response doPost(String url, String body){
        return given()
                .body(body)
                .when()
                .contentType(ContentType.JSON)
                .post(url)
                .then()
                .extract()
                .response();
    }

    public static Response doPostWithoutBody(String url, RequestSpecification spec){
        return given()
                .when()
                .spec(spec)
                .post(url)
                .then()
                .extract()
                .response();
    }
}
package rest;

import io.qameta.allure.Feature;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class RestTest {

    @Feature("Login")
    @Test
    public void searchTest() {
        given().
                baseUri("http://localhost:8086/").
                when().log().all().
                get("/search?title=200151").
                then().statusCode(200);
    }
}

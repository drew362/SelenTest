package rest;

import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.Stories;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static io.restassured.RestAssured.given;

@Feature("fg")
//@Stories("fgd")
public class RestTest {

    @Feature(value = "апи")

    @Test
    public void searchTest() {
        given().
                baseUri("http://localhost:8086/").
                when().log().all().
                get("/search?title=200151").
                then().statusCode(200);
    }
}

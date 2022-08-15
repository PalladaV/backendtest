package HW3;


import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;


public class ExampleTest extends AbstractTest {

    @Test
    void getSpecifyingRequestDataTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "pasta")
                .queryParam("cuisine", "Italian")
                .queryParam("excludeCuisine", "greek")
                .queryParam("diet", "vegetarian")
                .queryParam("includeIngredients", "tomato,cheese")
                .queryParam("limitLicense", "true")
                .when()
                .get(getBaseUrl() + "/recipes/complexSearch")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .time(lessThan(2000L));

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "soup")
                .queryParam("cuisine", "European")
                .queryParam("includeIngredients", "tomato")
                .queryParam("limitLicense", "true")
                .when()
                .get(getBaseUrl() + "/recipes/complexSearch")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .time(lessThan(2000L));

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "burger")
                .queryParam("cuisine", "American")
                .queryParam("number", "5")
                .queryParam("limitLicense", "true")
                .when()
                .get(getBaseUrl() + "/recipes/complexSearch")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .time(lessThan(2000L));

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "mousse")
                .queryParam("includeIngredients", "sugar")
                .queryParam("maxSugar", "80")
                .queryParam("type", "cream")
                .when()
                .get(getBaseUrl() + "/recipes/complexSearch")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .time(lessThan(2000L));

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "cake")
                .queryParam("cuisine", "European")
                .queryParam("fillIngredients", "false")
                .queryParam("maxCalories", "600")
                .queryParam("includeIngredients", "sugar")
                .when()
                .get(getBaseUrl() + "/recipes/complexSearch")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .time(lessThan(2000L));

        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Bacon-Apple-Pecan Stuffed French Toast")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .time(lessThan(2000L));

        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","5 Bean Chili")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .time(lessThan(2000L));

        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Chorizo Parmesan Brussels Sprouts Skillet")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .time(lessThan(2000L));

        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Amaretto Almond Cookies")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .time(lessThan(2000L));

        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Rum Raisin Carrot Cake with Cream Cheese Frosting")
                .when()
                .post(getBaseUrl()+"recipes/cuisine")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .time(lessThan(2000L));
    }

    @Test
    void addMealTest() {
        String id = given()
                .queryParam("hash", "38b81b96f34e2307ef46cfb456417ff21a7ae0e1")
                .queryParam("apiKey", getApiKey())
                .body("{\n"
                        + " \"date\": 1644881179,\n"
                        + " \"slot\": 1,\n"
                        + " \"position\": 0,\n"
                        + " \"type\": \"INGREDIENTS\",\n"
                        + " \"value\": {\n"
                        + " \"ingredients\": [\n"
                        + " {\n"
                        + " \"name\": \"2 coconut\"\n"
                        + " }\n"
                        + " ]\n"
                        + " }\n"
                        + "}")
                .when()
                .post("https://api.spoonacular.com/mealplanner/palladav/items")
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("id")
                .toString();

        given()
                .queryParam("hash", "38b81b96f34e2307ef46cfb456417ff21a7ae0e1")
                .queryParam("apiKey", getApiKey())
                .delete("https://api.spoonacular.com/mealplanner/palladav/items/" + id)
                .then()
                .statusCode(200);
    }
}

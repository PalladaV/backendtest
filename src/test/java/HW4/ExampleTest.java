package HW4;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.SneakyThrows;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExampleTest extends AbstractTest {

    @Test
    void getRecipePositiveTest() {
        given().spec(getRequestSpecification())
                .when()
                .get("https://api.spoonacular.com/recipes/716429/information")
                .then()
                .spec(responseSpecification);
    }


    @Test
    void getAccountInfoWithExternalEndpointTest(){
        Response response = given().spec(requestSpecification)
                .when()
                .formParam("title","cake")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(Response.class);
        assertThat(response.getCuisine(), containsString("European"));
    }

    @Test
    void test(){
        given().spec(requestSpecification)
                .when()
                .formParam("title","Bacon-Apple-Pecan Stuffed French Toast")
                .formParam("language", "en")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .statusCode(200);
    }


    @Test
    void getAccountInfoWithExternalEndpointTest2(){
        Response response = given().spec(requestSpecification)
                .when()
                .formParam("title","mousse")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(Response.class);
        assertThat(response.getCuisine(), containsString("European"));
    }

    @Test
    void test2(){
        given().spec(requestSpecification)
                .when()
                .formParam("title","5 Bean Chili")
                .formParam("language", "en")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .statusCode(200);
    }


    @Test
    void getAccountInfoWithExternalEndpointTest3(){
        Response response = given().spec(requestSpecification)
                .when()
                .formParam("title","burger")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(Response.class);
        assertThat(response.getCuisine(), containsString("American"));
    }


    @Test
    void test3(){
        given().spec(requestSpecification)
                .when()
                .formParam("title","Chorizo Parmesan Brussels Sprouts Skillet")
                .formParam("language", "en")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .statusCode(200);
    }

    @Test
    void getAccountInfoWithExternalEndpointTest4(){
        Response response = given().spec(requestSpecification)
                .when()
                .formParam("title","soup")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(Response.class);
        assertThat(response.getCuisine(), containsString("European"));
    }


    @Test
    void test4(){
        given().spec(requestSpecification)
                .when()
                .formParam("title","Amaretto Almond Cookies")
                .formParam("language", "en")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .statusCode(200);
    }


    @Test
    void getAccountInfoWithExternalEndpointTest5(){
        Response response = given().spec(requestSpecification)
                .when()
                .formParam("title","pasta")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .extract()
                .response()
                .body()
                .as(Response.class);
        assertThat(response.getCuisine(), containsString("Italian"));
    }


    @Test
    void test5(){
        given().spec(requestSpecification)
                .when()
                .formParam("title","Rum Raisin Carrot Cake with Cream Cheese Frosting")
                .formParam("language", "en")
                .post("https://api.spoonacular.com/recipes/cuisine").prettyPeek()
                .then()
                .statusCode(200);
    }
}

package HW3;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LoggingTest extends AbstractTest {

    @BeforeAll
    static void setUp() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

    }
}

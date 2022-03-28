import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import net.javacrumbs.jsonunit.JsonAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;


import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static org.hamcrest.Matchers.lessThan;


public class SpoonAccularApiTest extends BaseTest {

    private static final String API_KEY = "e256311898d64a67868915573dda48ef";
    private static final String BASE_URL = "https://api.spoonacular.com";

    @BeforeAll
    static void beforeAll() {

        RestAssured.baseURI = BASE_URL;

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addQueryParam("apiKey", API_KEY)
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectResponseTime(lessThan(3000L))
                .expectStatusCode(200)
                .build();
    }

    @Test //todo: Проверка на статус кода и время загрузки GET запроса
    void testGetComplexSearchBurger() throws IOException {

        String actually = RestAssured.given()
                .queryParam("query", "burger")
                .queryParam("cuisine", "european")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .when()
                .get("recipes/complexSearch")
                .body()
                .asPrettyString();

        String expected = getResourceAsString("expected.json");

        JsonAssert.assertJsonEquals(
                expected,
                actually,
                JsonAssert.when(IGNORING_ARRAY_ORDER)
        );

    }

    @Test
    void testGetComplexSearchPizza() {

        String actually = RestAssured.given()
                .queryParam("query", "pizza")
                .queryParam("cuisine", "italian")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .when()
                .get("recipes/complexSearch")
                .body()
                .asPrettyString();
    }
    @Test
    void testGetComplexSearchOreo() {

        String actually = RestAssured.given()
                .queryParam("query", "oreo")
                .queryParam("cuisine", "european")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .when()
                .get("recipes/complexSearch")
                .body()
                .asPrettyString();
    }
    @Test
    void testGetComplexSearchCake() {

        String actually = RestAssured.given()
                .queryParam("query", "cake")
                .queryParam("cuisine", "american")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .when()
                .get("recipes/complexSearch")
                .body()
                .asPrettyString();
    }
    @Test
    void testGetComplexSearchPan() {

        String actually = RestAssured.given()
                .queryParam("query", "pan")
                .queryParam("cuisine", "italian")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .when()
                .get("recipes/complexSearch")
                .body()
                .asPrettyString();
    }
    @Test//todo: Проверка на статус кода и время загрузки POST запроса
    void testClassifyGroceryProductPan() {

        String actually = RestAssured.given()
                .queryParam("query", "pan")
                .queryParam("cuisine", "italian")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .when()
                .post("recipes/cuisine")
                .body()
                .asPrettyString();
    }
    @Test
    void testClassifyGroceryProductCake() {

        String actually = RestAssured.given()
                .queryParam("query", "cake")
                .queryParam("cuisine", "american")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .when()
                .post("recipes/cuisine")
                .body()
                .asPrettyString();
    }
    @Test
    void testClassifyGroceryProductOreo() {

        String actually = RestAssured.given()
                .queryParam("query", "oreo")
                .queryParam("cuisine", "european")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .when()
                .post("recipes/cuisine")
                .body()
                .asPrettyString();
    }
    @Test
    void testClassifyGroceryProductPizza() {

        String actually = RestAssured.given()
                .queryParam("query", "pizza")
                .queryParam("cuisine", "italian")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .when()
                .post("recipes/cuisine")
                .body()
                .asPrettyString();
    }
    @Test
    void testClassifyGroceryProductBurger() {

        String actually = RestAssured.given()
                .queryParam("query", "burger")
                .queryParam("cuisine", "european")
                .log()
                .uri()
                .expect()
                .log()
                .body()
                .when()
                .post("recipes/cuisine")
                .asPrettyString();
    }

}

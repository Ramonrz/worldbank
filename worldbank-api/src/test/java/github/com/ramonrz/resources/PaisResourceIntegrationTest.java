package github.com.ramonrz.resources;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
class PaisResourceIntegrationTest {

    @Test
    void consultarPaisesTest() {
        given()
          .when().get("/api/v1/paises")
          .then()
             .statusCode(200)
             .body("size()", is(2))
             .body("paises[0].codigoPais", is("AW"));
    }
    
    @Test
    void consultarIndicadoresPaisTest() {
        given()
          .when().get("/api/v1/paises/indicadores/{pais}", "AW")
          .then()
              .statusCode(200)
              .body("size()", is(2))
              .body("indicadores[0].codigoPais", is("ABW"))
               .body("indicadores[0].data", is("2020"));
    }

}
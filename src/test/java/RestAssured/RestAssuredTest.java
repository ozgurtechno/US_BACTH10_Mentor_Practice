package RestAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredTest {

    private final String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4NjU0YWY0NmYyYjQ1MmEwNzMyYzZlNmFmMDdlMDBkZCIsInN1YiI6IjY1ZTliZjlmNWFiYTMyMDE2MzZmZjBiZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.O4Grq1LUD0S_haa1yTjcoB4YPtz66a2ctgBBzRsVJT4";

    @Test
    void task1() {

        given()
                .header("Authorization", "Bearer "+TOKEN)
                .when()
                .get("https://api.themoviedb.org/3/account/21072953")
                .then()
                .statusCode(200)
                .log().body();
    }


}

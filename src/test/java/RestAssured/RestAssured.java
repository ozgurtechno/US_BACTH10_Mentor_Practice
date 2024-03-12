package RestAssured;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAssured {

    private final String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4NjU0YWY0NmYyYjQ1MmEwNzMyYzZlNmFmMDdlMDBkZCIsInN1YiI6IjY1ZTliZjlmNWFiYTMyMDE2MzZmZjBiZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.O4Grq1LUD0S_haa1yTjcoB4YPtz66a2ctgBBzRsVJT4";

    private final String AccountId = "21072953";
    @Test
    void sendingToken(){

        given()
                .header("Authorization","Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .when()
                .get("https://api.themoviedb.org/3/account/"+AccountId)
                .then()
                .log().body();

    }
}

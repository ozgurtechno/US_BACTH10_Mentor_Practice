package RestAssured;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetTest {
    
    @Test()
    void getTest() {
        
        given()
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0ZmI3OWYzMTk2YjFkMGExNDFmNWY0MTcwYWVlMzBkNiIsInN1YiI6IjY1ZWE1MGI5NWFiYTMyMDE4NjcxOGJjNCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.PioHqjqESu_XPHOAI9AwfVqGblLG2y4oh6PF3QmCByU")
                .log().uri() //returns url which is being sent to see its correctness
                .when().get("https://api.themoviedb.org/3/account/21073777")
                .then()
                .log().body();

    }
}

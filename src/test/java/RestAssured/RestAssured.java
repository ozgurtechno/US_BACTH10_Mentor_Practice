package RestAssured;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAssured {
    @Test
    void sendingToken(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0MGE1ODFjNjkxZWEyNDU5ODI3MzhhMGM4NDY4MjJhZiIsInN1YiI6IjY1ZWE1MDZmNzJjMTNlMDE4NWM1OWU5MCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.fo_1uHwahtxqNS8lNvmxr5sCZrp54MvjPtmJP8RM3sY";
        given()
                .header("Authorization","bearer",token)
                .contentType(ContentType.JSON)
                .when()
                .get("https://api.themoviedb.org/3/account/21072953")
                .then();



    }
}

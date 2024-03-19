package RestAssured;

import RestAssured.POJO.Movie;
import RestAssured.POJO.MoviesResponse;
import RestAssured.POJO.User;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAssured {

    private final String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4NjU0YWY0NmYyYjQ1MmEwNzMyYzZlNmFmMDdlMDBkZCIsInN1YiI6IjY1ZTliZjlmNWFiYTMyMDE2MzZmZjBiZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.O4Grq1LUD0S_haa1yTjcoB4YPtz66a2ctgBBzRsVJT4";
    private final String AccountId = "21072953";
    private int movieId;
    @Test
    void accountDetails(){

        User response = given()
                .header("Authorization","Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .when()
                .get("https://api.themoviedb.org/3/account/"+AccountId)
                .then()
                .extract().as(User.class);

        System.out.println(response);
    }

    @Test
    void searchMovies(){
        MoviesResponse response = given()
                .header("Authorization","Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .queryParam("query","The Shawshank Redemption")
                .when()
                .get("https://api.themoviedb.org/3/search/movie")
                .then()
                .log().body()
                .extract().as(MoviesResponse.class);
        movieId = response.results.get(0).id;
        System.out.println(response);
    }

    @Test(dependsOnMethods = "searchMovies")
    void getMovieDetails(){
        Movie response = given()
                .header("Authorization","Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .when()
                .get("https://api.themoviedb.org/3/movie/"+movieId)
                .then()
                .log().body()
                .extract().as(Movie.class);
        System.out.println(response);
    }

    @Test(dependsOnMethods = "searchMovies")
    void addMovieRating(){
        given()
                .header("Authorization","Bearer "+TOKEN)
                .body("{\"value\":10}")
                .contentType(ContentType.JSON)
                .when()
                .post("https://api.themoviedb.org/3/movie/"+movieId+"/rating")
                .then()
                .statusCode(201)
                .log().body();
    }

    @Test
    void getRatedMovies(){

         MoviesResponse response = given()
                .header("Authorization","Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .when()
                .get("https://api.themoviedb.org/3/account/"+AccountId+"/rated/movies")
                .then()
                .extract().as(MoviesResponse.class);
        System.out.println(response);
    }

    @Test
    void getFavoredMovies(){
        MoviesResponse response = given()
                .header("Authorization","Bearer "+TOKEN)
                .contentType(ContentType.JSON)
                .when()
                .get("https://api.themoviedb.org/3/account/"+AccountId+"/favorite/movies")
                .then()
                .extract().as(MoviesResponse.class);
        System.out.println(response);
    }


}

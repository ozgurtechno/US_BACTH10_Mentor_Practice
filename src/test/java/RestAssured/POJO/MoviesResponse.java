package RestAssured.POJO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MoviesResponse {
    public String page;
    public List<Movie> results;

    @Override
    public String toString() {
        return "MoviesResponse{" +
                "page='" + page + '\'' +
                ", results=" + results +
                '}';
    }
}

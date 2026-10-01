package src;

import com.google.gson.Gson;

import java.util.List;

public class MovieJsonParser {

    public static List<Movie> parseMovies(String value) {
        Gson gson = new Gson();

        MovieResponse mr = gson.fromJson(value, MovieResponse.class);
        if (mr == null) {
            return List.of();
        }
        return mr.getResults();
    }
}

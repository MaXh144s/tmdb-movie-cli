package src;

import java.util.List;

public class MoviePrinter {

    public static void listMovies(List<Movie> movies) {
        movies.forEach(System.out::println);
    }

}

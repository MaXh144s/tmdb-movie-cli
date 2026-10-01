package src;

import java.util.List;

import com.google.gson.JsonSyntaxException;

public class Main {
    public static void main(String[] args) {

        List<Movie> results;

        if (args.length == 2 && args[0].toLowerCase().equals("--type")) {
            String type = args[1].toLowerCase();

            try {
                String title;
                String json;

                String apiKey = ConfigLoader.getApiKey();
                TmdbService ts = new TmdbService(apiKey);

                switch (type) {
                    case "popular":
                        title = "-> Filmes populares";
                        json = ts.mostPopular();
                        break;

                    case "playing":
                        title = "-> Filmes em cartaz";
                        json = ts.playing();
                        break;

                    case "top":
                        title = "-> Filmes mais bem avaliados";
                        json = ts.top();
                        break;

                    case "upcoming":
                        title = "-> Próximos filmes";
                        json = ts.upcoming();
                        break;

                    default:
                        System.err.println("Tipo de filme inválido.");
                        System.exit(1);
                        return;
                }

                System.out.println(title);

                results = MovieJsonParser.parseMovies(json);
                if (!results.isEmpty()) {
                    MoviePrinter.listMovies(results);
                } else {
                    System.out.println("Nenhum filme encontrado.");
                }
            } catch (TmdbException e) {
                System.err.println(e.getMessage());
                System.exit(1);
            } catch (JsonSyntaxException e) {
                System.err.println("Resposta inesperada da API.");
                System.exit(1);
            }
        } else {
            System.err.println("Comando não reconhecido, use: tmdb-app --type <popular|playing|top|upcoming>");
            System.exit(1);
        }
    }
}
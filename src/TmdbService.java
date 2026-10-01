package src;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class TmdbService {

    private static final String BASE_URL = "https://api.themoviedb.org/3/movie/";
    private final String apiKey;
    private final HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(5))
            .build();

    public TmdbService(String apiKey) {
        this.apiKey = apiKey;
    }

    public String mostPopular() {
        return fetch("popular");
    }

    public String playing() {
        return fetch("now_playing");
    }

    public String top() {
        return fetch("top_rated");
    }

    public String upcoming() {
        return fetch("upcoming");
    }

    private String fetch(String endpoint) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + endpoint + "?api_key=" + apiKey))
                .timeout(Duration.ofSeconds(10))
                .GET()
                .build();
        return sendRequest(request);
    }

    private String sendRequest(HttpRequest request) {
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                switch (response.statusCode()) {
                    case 401:
                        throw new TmdbException(
                                "API key inválida. Verifique a chave no arquivo de configuração");
                    case 404:
                        throw new TmdbException("Recurso não encontrado.");
                    case 429:
                        throw new TmdbException("Limite de requisições atingido.");
                    default:
                        throw new TmdbException(
                                "TMDB retornou HTTP " + response.statusCode());
                }
            }

            return response.body();

        } catch (IOException e) {
            throw new TmdbException("Erro de conexão com o TMDB.", e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new TmdbException("Requisição interrompida.", e);
        }
    }

}

package src;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TmdbService {
    private final String apiKey;
    private final HttpClient client = HttpClient.newHttpClient();

    public TmdbService(String apiKey){
        this.apiKey = apiKey;
    }

    public String mostPopular(){
        
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://api.themoviedb.org/3/movie/popular?api_key=" + apiKey))
        .GET()
        .build()
        ;

        try{
        HttpResponse<String> response = client.send(
            request,
            HttpResponse.BodyHandlers.ofString());

        return response.body();
    } 
    catch (IOException e){
        System.err.println("Error: " + e.getMessage());
        return null;
    } 
    catch (InterruptedException e){
        System.err.println("Error: " + e.getMessage());
        return null;
    }
    }

    public String playing(){
        
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://api.themoviedb.org/3/movie/now_playing?api_key=" + apiKey))
        .GET()
        .build()
        ;

        try{
        HttpResponse<String> response = client.send(
            request,
            HttpResponse.BodyHandlers.ofString());

        return response.body();
    } 
    catch (IOException e){
        System.err.println("Error: " + e.getMessage());
        return null;
    } 
    catch (InterruptedException e){
        System.err.println("Error: " + e.getMessage());
        return null;
    }
}

public String top(){
        
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://api.themoviedb.org/3/movie/top_rated?api_key=" + apiKey))
        .GET()
        .build()
        ;

        try{
        HttpResponse<String> response = client.send(
            request,
            HttpResponse.BodyHandlers.ofString());

        return response.body();
    } 
    catch (IOException e){
        System.err.println("Error: " + e.getMessage());
        return null;
    } 
    catch (InterruptedException e){
        System.err.println("Error: " + e.getMessage());
        return null;
    }
}

public String upcoming(){
        
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://api.themoviedb.org/3/movie/upcoming?api_key=" + apiKey))
        .GET()
        .build()
        ;

        try{
        HttpResponse<String> response = client.send(
            request,
            HttpResponse.BodyHandlers.ofString());

        return response.body();
    } 
    catch (IOException e){
        System.err.println("Error: " + e.getMessage());
        return null;
    } 
    catch (InterruptedException e){
        System.err.println("Error: " + e.getMessage());
        return null;
    }
}

}

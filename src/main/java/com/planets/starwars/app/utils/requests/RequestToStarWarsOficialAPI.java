package com.planets.starwars.app.utils.requests;

import com.planets.starwars.app.exceptions.PlanetNotFindException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestToStarWarsOficialAPI {
    private static final String baseUrl = "https://swapi.dev/api/";

    public static int GetPlanetFilmAppearances(String namePlanet) throws IOException, InterruptedException, PlanetNotFindException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "planets/?search=" + namePlanet))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (!response.body().contains("films")) {
            throw new PlanetNotFindException("Planet not find. Searched name: " + namePlanet);
        }

        Pattern patternFilms = Pattern.compile("films:\\[(https://swapi.dev/api/films/\\d+/,?)*]");
        String text = response.body().replaceAll("\"", "");
        Matcher matcher = patternFilms.matcher(text);

        if (matcher.find()) {
            text = matcher.group().replaceAll("[(films)\\[\\]]*", "");
            String[] values = text.split(",");
            return values.length;
        }

        throw new RuntimeException("Occurred some problem");
    }
}

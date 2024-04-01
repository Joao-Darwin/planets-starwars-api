package com.planets.starwars.app.utils.requests;

import com.planets.starwars.app.exceptions.PlanetNotFindException;
import com.planets.starwars.app.utils.requests.dtos.PlanetDataAPIOfficialResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RequestToStarWarsOficialAPI {
    private static final String BASE_URL = "https://swapi.dev/api/";

    public static int GetPlanetFilmAppearances(String namePlanet) throws PlanetNotFindException {
        RestTemplate restTemplate = new RestTemplate();

        String url = BASE_URL + "planets/?search=" + namePlanet;
        ResponseEntity<PlanetDataAPIOfficialResponse> planetData = restTemplate.getForEntity(url, PlanetDataAPIOfficialResponse.class);

        PlanetDataAPIOfficialResponse planetDataDTO = planetData.getBody();

        if (planetDataDTO.getCount() == 0) {
            throw new PlanetNotFindException("Planet don't find. Name searched: " + namePlanet);
        }

        if (!planetDataDTO.getResults().isEmpty()) {
            return planetDataDTO.getResults().get(0).getFilms().size();
        }

        throw new RuntimeException("Occurred some problem");
    }
}

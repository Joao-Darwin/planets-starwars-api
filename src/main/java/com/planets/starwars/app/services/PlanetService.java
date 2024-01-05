package com.planets.starwars.app.services;

import com.planets.starwars.app.dto.v1.PlanetRequestDTO;
import com.planets.starwars.app.dto.v1.PlanetResponseDTO;
import com.planets.starwars.app.models.Planet;
import com.planets.starwars.app.repositories.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {

    private final PlanetRepository planetRepository;

    @Autowired
    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public PlanetResponseDTO create(PlanetRequestDTO planet) {
        Planet planetEntity = new Planet();

        planetEntity.setName(planet.getName());
        planetEntity.setClimate(planet.getClimate());
        planetEntity.setGround(planet.getGround());
        planetEntity.setFilmAppearances(7);

        // TODO: 05/01/2024 - Aqui iria a solicitação para a API oficial buscando a quantidade de aparições. Caso não exixtisse retonava e não salvava no banco

        planetEntity = planetRepository.save(planetEntity);

        PlanetResponseDTO planetResponseDTO = new PlanetResponseDTO();

        planetResponseDTO.setId(planetEntity.getId());
        planetResponseDTO.setName(planetEntity.getName());
        planetResponseDTO.setClimate(planetEntity.getClimate());
        planetResponseDTO.setGround(planetEntity.getGround());
        planetResponseDTO.setFilmAppearances(planetEntity.getFilmAppearances());

        return planetResponseDTO;
    }
}

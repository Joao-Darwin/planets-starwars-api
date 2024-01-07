package com.planets.starwars.app.utils.conversions;

import com.planets.starwars.app.dto.v1.PlanetRequestDTO;
import com.planets.starwars.app.models.Planet;

public class ConvertPlanetRequestDTOToPlanetEntity {

    public static Planet convertPlanetRequestDTOToPlanetEntity(PlanetRequestDTO planetRequestDTO) {
        Planet planet = new Planet();

        planet.setName(planetRequestDTO.getName());
        planet.setClimate(planetRequestDTO.getClimate());
        planet.setGround(planetRequestDTO.getGround());

        return planet;
    }
}

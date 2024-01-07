package com.planets.starwars.app.utils.conversions;

import com.planets.starwars.app.dto.v1.PlanetResponseDTO;
import com.planets.starwars.app.models.Planet;

public class ConvertPlanetEntityToPlanetResponseDTO {

    public static PlanetResponseDTO convertPlanetEntityToPlanetResponseDTO(Planet planetEntity) {
        PlanetResponseDTO planetResponseDTO = new PlanetResponseDTO();

        planetResponseDTO.setId(planetEntity.getId());
        planetResponseDTO.setName(planetEntity.getName());
        planetResponseDTO.setClimate(planetEntity.getClimate());
        planetResponseDTO.setGround(planetEntity.getGround());
        planetResponseDTO.setFilmAppearances(planetEntity.getFilmAppearances());

        return planetResponseDTO;
    }
}

package com.planets.starwars.app.services;

import com.planets.starwars.app.dto.v1.PlanetRequestDTO;
import com.planets.starwars.app.dto.v1.PlanetResponseDTO;
import com.planets.starwars.app.exceptions.PlanetNotFindException;
import com.planets.starwars.app.models.Planet;
import com.planets.starwars.app.repositories.PlanetRepository;
import com.planets.starwars.app.utils.conversions.ConvertPlanetEntityToPlanetResponseDTO;
import com.planets.starwars.app.utils.conversions.ConvertPlanetRequestDTOToPlanetEntity;
import com.planets.starwars.app.utils.requests.RequestToStarWarsOficialAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class PlanetService {

    private final PlanetRepository planetRepository;

    @Autowired
    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public PlanetResponseDTO create(PlanetRequestDTO planet) throws IOException, InterruptedException, PlanetNotFindException {
        Planet planetEntity = ConvertPlanetRequestDTOToPlanetEntity.convertPlanetRequestDTOToPlanetEntity(planet);
        int filmAppearances = RequestToStarWarsOficialAPI.GetPlanetFilmAppearances(planet.getName());
        planetEntity.setFilmAppearances(filmAppearances);

        planetEntity = planetRepository.save(planetEntity);

        return ConvertPlanetEntityToPlanetResponseDTO.convertPlanetEntityToPlanetResponseDTO(planetEntity);
    }

    public List<PlanetResponseDTO> findAll() {
        List<Planet> planets = planetRepository.findAll();

        return ConvertPlanetEntityToPlanetResponseDTO.convertListPlanetEntityToListPlanerResponseDTO(planets);
    }

    public PlanetResponseDTO findByName(String name) {
        Planet planet = planetRepository.findByName(name);

        return ConvertPlanetEntityToPlanetResponseDTO.convertPlanetEntityToPlanetResponseDTO(planet);
    }

    public void delete(String id) {
        planetRepository.deleteById(id);
    }
}

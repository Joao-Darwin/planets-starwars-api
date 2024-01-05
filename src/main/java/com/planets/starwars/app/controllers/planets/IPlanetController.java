package com.planets.starwars.app.controllers.planets;

import com.planets.starwars.app.dto.v1.PlanetRequestDTO;
import com.planets.starwars.app.dto.v1.PlanetResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPlanetController {

    ResponseEntity<PlanetResponseDTO> create(PlanetRequestDTO planet);

    ResponseEntity<List<PlanetResponseDTO>> findAll();

    ResponseEntity<PlanetResponseDTO> findByName(String namePlanet);

    ResponseEntity<PlanetResponseDTO> findById(String id);

    ResponseEntity<PlanetResponseDTO> update(String id, PlanetRequestDTO planet);

    ResponseEntity<Void> delete(String id);
}

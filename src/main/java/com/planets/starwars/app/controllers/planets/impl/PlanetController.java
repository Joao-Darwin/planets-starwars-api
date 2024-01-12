package com.planets.starwars.app.controllers.planets.impl;

import com.planets.starwars.app.controllers.planets.IPlanetController;
import com.planets.starwars.app.dto.v1.PlanetRequestDTO;
import com.planets.starwars.app.dto.v1.PlanetResponseDTO;
import com.planets.starwars.app.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/planets")
public class PlanetController implements IPlanetController {

    private final PlanetService planetService;

    @Autowired
    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlanetResponseDTO> create(@RequestBody PlanetRequestDTO planet) {
        try {
            PlanetResponseDTO planetResponseDTO = planetService.create(planet);
            return ResponseEntity.status(HttpStatus.CREATED).body(planetResponseDTO);
        } catch (IOException | InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }

    @GetMapping
    public ResponseEntity<List<PlanetResponseDTO>> findAll() {
        List<PlanetResponseDTO> planetResponseDTOList = planetService.findAll();

        return ResponseEntity.status(200).body(planetResponseDTOList);
    }

    @GetMapping("/search")
    public ResponseEntity<PlanetResponseDTO> findByName(@RequestParam(value = "name") String namePlanet) {
        PlanetResponseDTO planetResponseDTO = planetService.findByName(namePlanet);

        return ResponseEntity.status(HttpStatus.OK).body(planetResponseDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PlanetResponseDTO> findById(@PathVariable(value = "id") String id) {
        PlanetResponseDTO planetResponseDTO = planetService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(planetResponseDTO);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlanetResponseDTO> update(@PathVariable(value = "id") String id, @RequestBody PlanetRequestDTO planet) {
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") String id) {
        planetService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

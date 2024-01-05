package com.planets.starwars.app.controllers.planets.impl;

import com.planets.starwars.app.controllers.planets.IPlanetController;
import com.planets.starwars.app.dto.v1.PlanetRequestDTO;
import com.planets.starwars.app.dto.v1.PlanetResponseDTO;
import com.planets.starwars.app.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return null;
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PlanetResponseDTO>> findAll() {
        return null;
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlanetResponseDTO> findByName(@RequestParam(value = "name") String namePlanet) {
        return null;
    }

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlanetResponseDTO> findById(@PathVariable(value = "id") String id) {
        return null;
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PlanetResponseDTO> update(@PathVariable(value = "id") String id, @RequestBody PlanetRequestDTO planet) {
        return null;
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable(value = "id") String id) {
        return null;
    }
}

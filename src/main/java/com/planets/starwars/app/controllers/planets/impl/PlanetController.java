package com.planets.starwars.app.controllers.planets.impl;

import com.planets.starwars.app.controllers.planets.IPlanetController;
import com.planets.starwars.app.dto.v1.OnlyIdAndLinksPlanetResponseDTO;
import com.planets.starwars.app.dto.v1.PlanetRequestDTO;
import com.planets.starwars.app.dto.v1.PlanetResponseDTO;
import com.planets.starwars.app.services.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
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

    @PostMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PlanetResponseDTO> create(@RequestBody PlanetRequestDTO planet) {
        try {
            PlanetResponseDTO planetResponseDTO = planetService.create(planet);
            return ResponseEntity.status(HttpStatus.CREATED).body(planetResponseDTO);
        } catch (IOException | InterruptedException exception) {
            throw new RuntimeException(exception);
        }
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PagedModel<EntityModel<OnlyIdAndLinksPlanetResponseDTO>>> findAll(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(value = "sort", defaultValue = "asc") String sort
    ) {
        Sort.Direction sortDirection = sort.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "name"));

        return ResponseEntity.status(200).body(planetService.findAll(pageable));
    }

    @GetMapping(value = "/search",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PlanetResponseDTO> findByName(@RequestParam(value = "name") String namePlanet) {
        PlanetResponseDTO planetResponseDTO = planetService.findByName(namePlanet);

        return ResponseEntity.status(HttpStatus.OK).body(planetResponseDTO);
    }

    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PlanetResponseDTO> findById(@PathVariable(value = "id") String id) {
        PlanetResponseDTO planetResponseDTO = planetService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(planetResponseDTO);
    }

    @PutMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PlanetResponseDTO> update(@PathVariable(value = "id") String id, @RequestBody PlanetRequestDTO planet) {
        PlanetResponseDTO planetResponseDTO = planetService.update(id, planet);

        return ResponseEntity.status(HttpStatus.OK).body(planetResponseDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") String id) {
        planetService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

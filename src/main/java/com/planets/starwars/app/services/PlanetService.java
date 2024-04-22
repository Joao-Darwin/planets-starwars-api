package com.planets.starwars.app.services;

import com.planets.starwars.app.controllers.planets.impl.PlanetController;
import com.planets.starwars.app.dto.v1.OnlyIdAndLinksPlanetResponseDTO;
import com.planets.starwars.app.dto.v1.PlanetRequestDTO;
import com.planets.starwars.app.dto.v1.PlanetResponseDTO;
import com.planets.starwars.app.exceptions.PlanetAlreadyExistsException;
import com.planets.starwars.app.exceptions.PlanetNotFindException;
import com.planets.starwars.app.models.Planet;
import com.planets.starwars.app.repositories.PlanetRepository;
import com.planets.starwars.app.utils.conversions.ConvertPlanetEntityToPlanetResponseDTO;
import com.planets.starwars.app.utils.conversions.ConvertPlanetRequestDTOToPlanetEntity;
import com.planets.starwars.app.utils.requests.RequestToStarWarsOficialAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PlanetService {

    private static final String PLANET_NOT_FIND_MESSAGE = "Planet don't find";
    private static final String PLANET_ALREADY_EXISTS_MESSAGE = "Planet already exists";
    private final PlanetRepository planetRepository;
    private final PagedResourcesAssembler<OnlyIdAndLinksPlanetResponseDTO> assembler;

    @Autowired
    public PlanetService(PlanetRepository planetRepository, PagedResourcesAssembler<OnlyIdAndLinksPlanetResponseDTO> assembler) {
        this.planetRepository = planetRepository;
        this.assembler = assembler;
    }

    public PlanetResponseDTO create(PlanetRequestDTO planet) throws IOException, InterruptedException, PlanetNotFindException {
        Planet planetExist = planetRepository.findByName(planet.getName());

        if (!(planetExist == null)) {
            throw new PlanetAlreadyExistsException(PLANET_ALREADY_EXISTS_MESSAGE);
        }

        Planet planetEntity = ConvertPlanetRequestDTOToPlanetEntity.convertPlanetRequestDTOToPlanetEntity(planet);
        int filmAppearances = RequestToStarWarsOficialAPI.GetPlanetFilmAppearances(planet.getName());
        planetEntity.setFilmAppearances(filmAppearances);

        planetEntity = planetRepository.save(planetEntity);

        PlanetResponseDTO planetResponseDTO = ConvertPlanetEntityToPlanetResponseDTO.convertPlanetEntityToPlanetResponseDTO(planetEntity);
        planetResponseDTO.add(
                linkTo(methodOn(PlanetController.class).findById(planetResponseDTO.getId())).withSelfRel().withTitle("FindById"),
                linkTo(methodOn(PlanetController.class).findByName(planetResponseDTO.getName())).withSelfRel().withTitle("FindByName"));

        return planetResponseDTO;
    }

    public PagedModel<EntityModel<OnlyIdAndLinksPlanetResponseDTO>> findAll(Pageable pageable) {
        Page<Planet> planets = planetRepository.findAll(pageable);

        Page<OnlyIdAndLinksPlanetResponseDTO> planetResponseDTOS = planets.map(planet -> new OnlyIdAndLinksPlanetResponseDTO(planet.getId(), planet.getName()));

        planetResponseDTOS.map(planet -> planet.add(
                linkTo(methodOn(PlanetController.class).findById(planet.getId())).withSelfRel().withTitle("FindById"),
                linkTo(methodOn(PlanetController.class).findByName(planet.getName())).withSelfRel().withTitle("FindByName")
        ));

        Link linkPage = linkTo(methodOn(PlanetController.class).findAll(pageable.getPageNumber(), pageable.getPageSize(), "asc")).withSelfRel();

        return assembler.toModel(planetResponseDTOS, linkPage);
    }

    public PlanetResponseDTO findByName(String name) {
        Planet planet = planetRepository.findByName(name);

        if (planet == null) {
            throw new PlanetNotFindException(PLANET_NOT_FIND_MESSAGE);
        }

        return ConvertPlanetEntityToPlanetResponseDTO.convertPlanetEntityToPlanetResponseDTO(planet);
    }

    public PlanetResponseDTO findById(String id) {
        Planet planet = planetRepository.findById(id).orElseThrow(() -> new PlanetNotFindException(PLANET_NOT_FIND_MESSAGE));

        return ConvertPlanetEntityToPlanetResponseDTO.convertPlanetEntityToPlanetResponseDTO(planet);
    }

    public PlanetResponseDTO update(String id, PlanetRequestDTO planetRequestDTO) {
        Planet planet = planetRepository.findById(id).orElseThrow(() -> new PlanetNotFindException(PLANET_NOT_FIND_MESSAGE));

        int filmAppearances = RequestToStarWarsOficialAPI.GetPlanetFilmAppearances(planetRequestDTO.getName());

        planet.setName(planetRequestDTO.getName());
        planet.setGround(planetRequestDTO.getGround());
        planet.setClimate(planetRequestDTO.getClimate());
        planet.setFilmAppearances(filmAppearances);

        Planet planetExist = planetRepository.findByName(planet.getName());

        if (!(planetExist == null)) {
            throw new PlanetAlreadyExistsException(PLANET_ALREADY_EXISTS_MESSAGE);
        }

        return ConvertPlanetEntityToPlanetResponseDTO.convertPlanetEntityToPlanetResponseDTO(planetRepository.save(planet));
    }

    public void delete(String id) {
        planetRepository.deleteById(id);
    }
}

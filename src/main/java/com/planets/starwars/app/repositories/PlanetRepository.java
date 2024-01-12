package com.planets.starwars.app.repositories;

import com.planets.starwars.app.models.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, String> {
    Planet findByName(String name);
}

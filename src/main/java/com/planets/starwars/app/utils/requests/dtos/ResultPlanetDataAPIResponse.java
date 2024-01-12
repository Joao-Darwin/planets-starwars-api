package com.planets.starwars.app.utils.requests.dtos;

import java.util.List;

public class ResultPlanetDataAPIResponse {
    private String name;
    private String rotation_period;
    private String orbital_period;
    private String population;
    private List<String> residents;
    private List<String> films;

    public ResultPlanetDataAPIResponse(String name, String rotation_period, String orbital_period, String population, List<String> residents, List<String> films) {
        this.name = name;
        this.rotation_period = rotation_period;
        this.orbital_period = orbital_period;
        this.population = population;
        this.residents = residents;
        this.films = films;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRotation_period() {
        return rotation_period;
    }

    public void setRotation_period(String rotation_period) {
        this.rotation_period = rotation_period;
    }

    public String getOrbital_period() {
        return orbital_period;
    }

    public void setOrbital_period(String orbital_period) {
        this.orbital_period = orbital_period;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public List<String> getResidents() {
        return residents;
    }

    public void setResidents(List<String> residents) {
        this.residents = residents;
    }

    public List<String> getFilms() {
        return films;
    }

    public void setFilms(List<String> films) {
        this.films = films;
    }
}

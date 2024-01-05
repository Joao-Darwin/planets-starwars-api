package com.planets.starwars.app.dto.v1;

import java.io.Serial;
import java.io.Serializable;

public class PlanetResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String climate;
    private String ground;
    private int filmAppearances;

    public PlanetResponseDTO() {
    }

    public PlanetResponseDTO(String id, String name, String climate, String ground, int filmAppearances) {
        this.id = id;
        this.name = name;
        this.climate = climate;
        this.ground = ground;
        this.filmAppearances = filmAppearances;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getGround() {
        return ground;
    }

    public void setGround(String ground) {
        this.ground = ground;
    }

    public int getFilmAppearances() {
        return filmAppearances;
    }

    public void setFilmAppearances(int filmAppearances) {
        this.filmAppearances = filmAppearances;
    }
}

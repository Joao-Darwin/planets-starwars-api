package com.planets.starwars.app.dto.v1;

import java.io.Serial;
import java.io.Serializable;

public class PlanetRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String name;
    private String climate;
    private String ground;

    public PlanetRequestDTO() {
    }

    public PlanetRequestDTO(String name, String climate, String ground) {
        this.name = name;
        this.climate = climate;
        this.ground = ground;
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
}

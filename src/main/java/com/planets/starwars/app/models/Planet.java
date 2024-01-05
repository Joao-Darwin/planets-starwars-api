package com.planets.starwars.app.models;

import jakarta.persistence.*;

@Entity
@Table(name = "planets")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String climate;
    private String ground;
    private int filmAppearances;

    public Planet() {
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

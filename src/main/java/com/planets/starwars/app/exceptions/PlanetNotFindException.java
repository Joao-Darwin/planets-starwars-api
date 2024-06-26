package com.planets.starwars.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PlanetNotFindException extends RuntimeException{

    private String message;

    public PlanetNotFindException(String message) {
        super(message);
    }
}

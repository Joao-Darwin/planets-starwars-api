package com.planets.starwars.app.utils.requests.dtos;

import java.util.List;

public class PlanetDataAPIOfficialResponse {
    private int count;
    private String next;
    private String previous;
    private List<ResultPlanetDataAPIResponse> results;

    public PlanetDataAPIOfficialResponse(int count, String next, String previous, List<ResultPlanetDataAPIResponse> results) {
        this.count = count;
        this.next = next;
        this.previous = previous;
        this.results = results;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<ResultPlanetDataAPIResponse> getResults() {
        return results;
    }

    public void setResults(List<ResultPlanetDataAPIResponse> results) {
        this.results = results;
    }
}

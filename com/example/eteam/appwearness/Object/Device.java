package com.example.eteam.appwearness.Object;

public class Device {
    private Coordinate coordinate;
    private int id;
    private String location;
    private String token;

    public Device(String token) {
        this.token = token;
    }

    public Device(int id, String location, String token, Coordinate coordinate) {
        this.id = id;
        this.location = location;
        this.token = token;
        this.coordinate = coordinate;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}

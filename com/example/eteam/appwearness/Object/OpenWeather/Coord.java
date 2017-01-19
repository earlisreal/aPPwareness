package com.example.eteam.appwearness.Object.OpenWeather;

public class Coord {
    private double lat;
    private double lon;

    public Coord(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public double getLon() {
        return this.lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return this.lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String toString() {
        return "lat -> " + getLat() + " lon -> " + getLon();
    }
}

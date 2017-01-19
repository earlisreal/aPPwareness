package com.example.eteam.appwearness.Object.OpenWeather;

import com.google.gson.annotations.SerializedName;

public class Snow {
    @SerializedName("3h")
    private double volume;

    public Snow(double volume) {
        this.volume = volume;
    }

    public double getVolume() {
        return this.volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }
}

package com.skptech.demo.model;

public class Weather {

    private boolean rain;
    private String description;

    public Weather(boolean rain, String description) {
        this.rain = rain;
        this.description = description;
    }

    public boolean isRain() {
        return rain;
    }

    public void setRain(boolean rain) {
        this.rain = rain;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

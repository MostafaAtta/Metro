package com.atta.metro.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Result {

    @SerializedName("rows")
    private ArrayList<MetroStation> metroStations;

    public Result() {
    }

    public ArrayList<MetroStation> getMetroStations() {
        return metroStations;
    }

    public void setMetroStations(ArrayList<MetroStation> metroStations) {
        this.metroStations = metroStations;
    }
}

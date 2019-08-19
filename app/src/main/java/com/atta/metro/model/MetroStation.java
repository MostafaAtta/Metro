package com.atta.metro.model;

import com.google.gson.annotations.SerializedName;

public class MetroStation {

    @SerializedName("destination_Long_Lat")
    String[] latLng;
    @SerializedName("title")
    String title;

    public MetroStation(String[] latLng, String title) {
        this.latLng = latLng;
        this.title = title;
    }

    public String[] getLatLng() {
        return latLng;
    }

    public String getTitle() {
        return title;
    }

    public double getLat() {
        return Double.valueOf(latLng[0].split(",")[0]);
    }


    public double getLng() {
        return Double.valueOf(latLng[0].split(",")[1]);
    }
}

package com.atta.metro.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("metro.json")
    Call<Result> getStations();


}

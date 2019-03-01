package com.androiddesdecero.daggerretrofitrecyclerview.api;

import com.androiddesdecero.daggerretrofitrecyclerview.model.Meteorologia;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by albertopalomarrobledo on 28/2/19.
 */

public interface ApiClient {
    @GET("data/2.5/forecast?id=524901&appid=b1b15e88fa797225412429c1c50c122a1")
    Call<Meteorologia> getTiempo();
}

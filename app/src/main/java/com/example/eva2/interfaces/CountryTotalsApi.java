package com.example.eva2.interfaces;

import com.example.eva2.modelo.Pais;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CountryTotalsApi {
    @GET("v1")
    Call<List<Pais>> getPais();
}

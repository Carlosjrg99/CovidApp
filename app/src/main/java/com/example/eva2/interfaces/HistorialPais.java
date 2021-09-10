package com.example.eva2.interfaces;
import com.example.eva2.modelo.Historial;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HistorialPais {
    @GET("dayone/country/{nombre}/status/confirmed")
    Call<List<Historial>> setGet(@Path("nombre") String nombre);
}

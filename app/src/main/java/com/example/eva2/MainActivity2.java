package com.example.eva2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eva2.interfaces.CountryTotalsApi;
import com.example.eva2.interfaces.HistorialPais;
import com.example.eva2.modelo.Historial;
import com.example.eva2.modelo.Pais;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle extras = getIntent().getExtras();
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView titulo = findViewById(R.id.toolbar_title);
        titulo.append("Detalles");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        String nombre = extras.getString("nombre");
        setPais(nombre);
    }

    private void setPais(String nombre) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.covid19api.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        HistorialPais historialPais = retrofit.create(HistorialPais.class);
        Call<List<Historial>> historial = historialPais.setGet(nombre);
        historial.enqueue(new Callback<List<Historial>>() {
            @Override
            public void onResponse(Call<List<Historial>> call, Response<List<Historial>> response) {
                if (!response.isSuccessful()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Codigo Error HTTP: " + response.code(), Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }
                List<Historial> listaHistorial = response.body();
                TextView title = findViewById(R.id.textView);
                title.append("Casos en " + listaHistorial.get(0).getPais());
                List<String> listado = new ArrayList<>();
                for (Historial elemento : listaHistorial) {
                    listado.add("Total de casos: " + elemento.getCasos() + "\nFecha: " + elemento.getFecha());
                }
                ListView lista = findViewById(R.id.lista);
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                        getApplicationContext(),
                        android.R.layout.simple_list_item_1,
                        listado);
                lista.setAdapter(arrayAdapter);
            }

            @Override
            public void onFailure(Call<List<Historial>> call, Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

}
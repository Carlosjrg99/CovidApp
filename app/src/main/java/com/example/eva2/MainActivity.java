package com.example.eva2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eva2.interfaces.CountryTotalsApi;
import com.example.eva2.modelo.Pais;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView titulo = findViewById(R.id.toolbar_title);
        titulo.append("Coronavirus App");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getPais();
    }

    private void getPais() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://covid-19.dataflowkit.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CountryTotalsApi countryTotalsApi = retrofit.create(CountryTotalsApi.class);
        Call<List<Pais>> llamada = countryTotalsApi.getPais();
        llamada.enqueue(new Callback<List<Pais>>() {
            @Override
            public void onResponse(Call<List<Pais>> call, Response<List<Pais>> response) {
                if (!response.isSuccessful()) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Codigo Error HTTP: " + response.code(), Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }
                TextView mostrar = findViewById(R.id.mostrar);
                List<Pais> listaPais = response.body();
                mostrar.append("Resumen Global\n\n" +
                        "Totales:\nCasos: " + listaPais.get(0).getCasosTotales() + "\n" +
                        "Recuperados: " + listaPais.get(0).getRecuperadosTotales() + "\n" +
                        "Muertes: " + listaPais.get(0).getMuertesTotales() + "\n\n" +
                        "Nuevos (hoy):\nCasos : " + listaPais.get(0).getNuevosCasos() + "\n" +
                        "Muertes: " + listaPais.get(0).getNuevasMuertes() + "\n\n" +
                        "Casos activos: " + listaPais.get(0).getCasosActivos() + "\n\n" +
                        "Actualizado: "+listaPais.get(0).getUltimaActualizacion() + "\n");
                Spinner spinner = findViewById(R.id.spinner);
                ArrayAdapter<Pais> adaptador = new ArrayAdapter<Pais>(MainActivity.this, android.R.layout.simple_spinner_item, listaPais);
                adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adaptador);
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        Pais pais = (Pais) parent.getSelectedItem();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Pais>> call, Throwable t) {
                Toast toast = Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }


    public void setPais(View v) {
        Toast toast;
        Spinner spinner = findViewById(R.id.spinner);
        Pais pais = (Pais) spinner.getSelectedItem();
        String nombre = pais.getNombre();
        switch (nombre){
            case "World":
                toast = Toast.makeText(getApplicationContext(), "Seleccionar país", Toast.LENGTH_LONG);
                toast.show();
                return;
            case "USA":
                nombre = "US";
                break;
            case "UAE":
                nombre = "AE";
                break;
            case "S. Korea":
                nombre = "KR";
                break;
            case "DRC":
                nombre = "CG";
                break;
            case "CAR":
                nombre = "CF";
                break;
            case "Réunion":
            case "St. Bart":
                toast = Toast.makeText(getApplicationContext(), "País no soportado", Toast.LENGTH_LONG);
                toast.show();
                return;
            case "Diamond Princess":
            case "MS Zaandam":
                toast = Toast.makeText(getApplicationContext(), "Solo se soportan países", Toast.LENGTH_LONG);
                toast.show();
                return;
            default:
                break;
        }
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("nombre", nombre);
        startActivity(intent);
    }
}
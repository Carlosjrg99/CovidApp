package com.example.eva2.modelo;

import com.google.gson.annotations.SerializedName;

public class Historial {
    @SerializedName("Country")
    String pais;
    @SerializedName("CountryCode")
    String codigo;
    @SerializedName("Province")
    String provincia;
    @SerializedName("City")
    String ciudad;
    @SerializedName("CityCode")
    String codCiudad;
    @SerializedName("Lat")
    String latitus;
    @SerializedName("Lon")
    String longitud;
    @SerializedName("Cases")
    int casos;
    @SerializedName("Status")
    String estado;
    @SerializedName("Date")
    String fecha;

    public Historial(String pais, String codigo, String provincia, String ciudad, String codCiudad, String latitus, String longitud, int casos, String estado, String fecha) {
        this.pais = pais;
        this.codigo = codigo;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.codCiudad = codCiudad;
        this.latitus = latitus;
        this.longitud = longitud;
        this.casos = casos;
        this.estado = estado;
        this.fecha = fecha;
    }

    public String getPais() {
        return pais;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCodCiudad() {
        return codCiudad;
    }

    public String getLatitus() {
        return latitus;
    }

    public String getLongitud() {
        return longitud;
    }

    public int getCasos() {
        return casos;
    }

    public String getEstado() {
        return estado;
    }

    public String getFecha() {
        return fecha;
    }
}

package com.example.eva2.modelo;

import com.google.gson.annotations.SerializedName;

public class Pais {
    @SerializedName("Active Cases_text")
    private String casosActivos;
    @SerializedName("Country_text")
    private String nombre;
    @SerializedName("Last Update")
    private String ultimaActualizacion;
    @SerializedName("New Cases_text")
    private String nuevosCasos;
    @SerializedName("New Deaths_text")
    private String nuevasMuertes;
    @SerializedName("Total Cases_text")
    private String casosTotales;
    @SerializedName("Total Deaths_text")
    private String muertesTotales;
    @SerializedName("Total Recovered_text")
    private String recuperadosTotales;

    public Pais(String casosActivos, String nombre, String ultimaActualizacion, String nuevosCasos, String nuevasMuertes, String casosTotales, String muertesTotales, String recuperadosTotales) {
        this.casosActivos = casosActivos;
        this.nombre = nombre;
        this.ultimaActualizacion = ultimaActualizacion;
        this.nuevosCasos = nuevosCasos;
        this.nuevasMuertes = nuevasMuertes;
        this.casosTotales = casosTotales;
        this.muertesTotales = muertesTotales;
        this.recuperadosTotales = recuperadosTotales;
    }

    public String getCasosActivos() {
        return casosActivos;
    }

    public void setCasosActivos(String casosActivos) {
        this.casosActivos = casosActivos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public void setUltimaActualizacion(String ultimaActualizacion) {
        this.ultimaActualizacion = ultimaActualizacion;
    }

    public String getNuevosCasos() {
        return nuevosCasos;
    }

    public void setNuevosCasos(String nuevosCasos) {
        this.nuevosCasos = nuevosCasos;
    }

    public String getNuevasMuertes() {
        return nuevasMuertes;
    }

    public void setNuevasMuertes(String nuevasMuertes) {
        this.nuevasMuertes = nuevasMuertes;
    }

    public String getCasosTotales() {
        return casosTotales;
    }

    public void setCasosTotales(String casosTotales) {
        this.casosTotales = casosTotales;
    }

    public String getMuertesTotales() {
        return muertesTotales;
    }

    public void setMuertesTotales(String muertesTotales) {
        this.muertesTotales = muertesTotales;
    }

    public String getRecuperadosTotales() {
        return recuperadosTotales;
    }

    public void setRecuperadosTotales(String recuperadosTotales) {
        this.recuperadosTotales = recuperadosTotales;
    }

    @Override
    public String toString() {
        return nombre.equals("World")?"Mundo":nombre;
    }
}

package com.example.jonathanguerrero.senasoftapp;

/**
 * Created by jonathanguerrero on 11/04/17.
 */

public class Categoria {
    private int icono;
    private String titulo;
    private String resumen;

    public Categoria(int icono, String titulo, String resumen) {
        this.icono = icono;
        this.titulo = titulo;
        this.resumen = resumen;
    }

    public Categoria() {
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }
}

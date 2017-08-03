package com.example.jonathanguerrero.senasoftapp.gestiondatos;

import com.orm.SugarRecord;

/**
 * Created by jonathanguerrero on 14/04/17.
 */

public class Resultado extends SugarRecord{

    private String competencia;
    private String aprendices;
    private String region;
    private double total;
    private double dia_1;
    private double dia_2;
    private double dia_3;

    public Resultado(String competencia, String aprendices, String region, double total, double dia_1, double dia_2, double dia_3) {
        this.competencia = competencia;
        this.aprendices = aprendices;
        this.region = region;
        this.total = total;
        this.dia_1 = dia_1;
        this.dia_2 = dia_2;
        this.dia_3 = dia_3;
    }

    public Resultado() {
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public String getAprendices() {
        return aprendices;
    }

    public void setAprendices(String aprendices) {
        this.aprendices = aprendices;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDia_1() {
        return dia_1;
    }

    public void setDia_1(double dia_1) {
        this.dia_1 = dia_1;
    }

    public double getDia_2() {
        return dia_2;
    }

    public void setDia_2(double dia_2) {
        this.dia_2 = dia_2;
    }

    public double getDia_3() {
        return dia_3;
    }

    public void setDia_3(double dia_3) {
        this.dia_3 = dia_3;
    }
}

package com.androiddesdecero.daggerretrofitrecyclerview.model;

/**
 * Created by albertopalomarrobledo on 28/2/19.
 */

public class Tiempo {

    private TiempoDiario main;
    private String dt;

    public TiempoDiario getMain() {
        return main;
    }

    public void setMain(TiempoDiario main) {
        this.main = main;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }
}

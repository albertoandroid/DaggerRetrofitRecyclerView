package com.androiddesdecero.daggerretrofitrecyclerview.model;

import java.util.List;

/**
 * Created by albertopalomarrobledo on 28/2/19.
 */

public class Meteorologia {

    private List<Tiempo> list;

    public List<Tiempo> getTiempos() {
        return list;
    }

    public void setTiempos(List<Tiempo> tiempos) {
        this.list = tiempos;
    }
}

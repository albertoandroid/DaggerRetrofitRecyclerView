package com.androiddesdecero.daggerretrofitrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androiddesdecero.daggerretrofitrecyclerview.model.Meteorologia;
import com.androiddesdecero.daggerretrofitrecyclerview.model.Tiempo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by albertopalomarrobledo on 1/3/19.
 */

public class TiempoAdapter extends RecyclerView.Adapter<TiempoAdapter.TiempoViewHolder> {

    private List<Tiempo> metereologia;

    public TiempoAdapter(){
        metereologia = new ArrayList<>();
    }

    @NonNull
    @Override
    public TiempoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_tiempo, viewGroup, false);
        return new TiempoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TiempoViewHolder tiempoViewHolder, int i) {
        Tiempo tiempo = new Tiempo();
        tiempo = metereologia.get(i);
        Long tiempoLong = Long.parseLong(tiempo.getDt());
        Date date = new Date((long)tiempoLong*1000);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String tiempoString = simpleDateFormat.format(date);
        tiempoViewHolder.litFecha.setText(tiempoString);
        tiempoViewHolder.litTemperatura.setText(tiempo.getMain().getTemp());
        tiempoViewHolder.litHumedad.setText(tiempo.getMain().getHumidity());
    }

    @Override
    public int getItemCount() {
        return metereologia.size();
    }

    public class TiempoViewHolder extends RecyclerView.ViewHolder{

        private TextView litFecha;
        private TextView litHumedad;
        private TextView litTemperatura;

        public TiempoViewHolder(View itemView){
            super(itemView);
            litFecha = itemView.findViewById(R.id.litFecha);
            litHumedad = itemView.findViewById(R.id.litHumedad);
            litTemperatura = itemView.findViewById(R.id.litTemperatura);
        }
    }

    public void setData(List<Tiempo> data) {
        this.metereologia.addAll(data);
        notifyDataSetChanged();
    }
}

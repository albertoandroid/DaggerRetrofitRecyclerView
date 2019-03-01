package com.androiddesdecero.daggerretrofitrecyclerview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.androiddesdecero.daggerretrofitrecyclerview.api.ApiClient;
import com.androiddesdecero.daggerretrofitrecyclerview.model.Meteorologia;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Named;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    public static final String TEMPERATURA = "temperatura";
    public static final String TEMPERATURA_INT = "temperatura_int";
    private TextView textView;

    //@Inject
    //SharedPreferences sharedPreferences;

    @Inject
    Retrofit retrofit;

    @Inject
    TiempoAdapter adapter2;

    private RecyclerView listaTemperatura;
    private TiempoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaTemperatura = findViewById(R.id.rvLista);
        LinearLayoutManager lim = new LinearLayoutManager(this);
        lim.setOrientation(LinearLayoutManager.VERTICAL);
        listaTemperatura.setLayoutManager(lim);

        //adapter = new TiempoAdapter();
        //listaTemperatura.setAdapter(adapter2);


        //((BaseApplication)getApplication())
        //        .getApplicationContextComponent().inject(this);
        //((BaseApplication)getApplication()).plusSharedPreferencesSubComponent().inject(this);

        ((BaseApplication)getApplication()).plusRetrofitsubComponent().inject(this);
        listaTemperatura.setAdapter(adapter2);


        ApiClient apiClient = retrofit.create(ApiClient.class);
        Call<Meteorologia> call = apiClient.getTiempo();
        call.enqueue(new Callback<Meteorologia>() {
            @Override
            public void onResponse(Call<Meteorologia> call, Response<Meteorologia> response) {
                Log.d("TAG1", response.body().getTiempos().get(0).getDt());
                adapter2.setData(response.body().getTiempos());
            }

            @Override
            public void onFailure(Call<Meteorologia> call, Throwable t) {
                Log.d("TAG1", "Error" + t.toString());

            }
        });

        textView = findViewById(R.id.tvText);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Main2Activity.class));
            }
        });







        /*
        //to write in sharedpref
        SharedPreferences.Editor prefEditor = sharedPreferences.edit();
        prefEditor.putString(TEMPERATURA, "21 grados");
        prefEditor.putInt(TEMPERATURA_INT, 22);
        prefEditor.apply();

        //to read from sharedPref
        String temperatura = sharedPreferences.getString(TEMPERATURA, "DEFAULT");
        int temperatura_int = sharedPreferences.getInt(TEMPERATURA_INT, 0);
        Toast.makeText(this, "Temperatura " + temperatura +
                "Temperatura Int  " + temperatura_int, Toast.LENGTH_SHORT).show();

*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //if()
    }
}

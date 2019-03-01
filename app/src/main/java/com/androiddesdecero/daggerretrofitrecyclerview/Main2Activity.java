package com.androiddesdecero.daggerretrofitrecyclerview;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import javax.inject.Inject;

public class Main2Activity extends AppCompatActivity {

    public static final String TEMPERATURA = "temperatura";
    public static final String TEMPERATURA_INT = "temperatura_int";

    @Inject
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ((BaseApplication)getApplication()).plusSharedPreferencesSubComponent().inject(this);

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
    }
}

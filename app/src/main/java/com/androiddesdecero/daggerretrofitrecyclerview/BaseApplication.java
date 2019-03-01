package com.androiddesdecero.daggerretrofitrecyclerview;

import android.app.Application;

import com.androiddesdecero.daggerretrofitrecyclerview.di.component.ApplicationContextComponent;
import com.androiddesdecero.daggerretrofitrecyclerview.di.component.DaggerApplicationContextComponent;
import com.androiddesdecero.daggerretrofitrecyclerview.di.component.RetrofitSubComponent;
import com.androiddesdecero.daggerretrofitrecyclerview.di.component.SharedPreferencesSubComponent;
import com.androiddesdecero.daggerretrofitrecyclerview.di.module.ApplicationContextModule;
import com.androiddesdecero.daggerretrofitrecyclerview.di.module.RetrofitModule;
import com.androiddesdecero.daggerretrofitrecyclerview.di.module.SharedPreferencesModule;

/**
 * Created by albertopalomarrobledo on 27/2/19.
 */

public class BaseApplication extends Application {

    private SharedPreferencesSubComponent sharedPreferencesSubComponent;
    private ApplicationContextComponent applicationContextComponent;
    private RetrofitSubComponent retrofitSubComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setupGraph();
    }

    private void setupGraph(){
        applicationContextComponent = DaggerApplicationContextComponent
                .builder()
                .applicationContextModule(new ApplicationContextModule(this))
                .build();
    }

    private void clearApplicationContextComponent(){
        applicationContextComponent = null;
    }


    public SharedPreferencesSubComponent plusSharedPreferencesSubComponent(){
        if(sharedPreferencesSubComponent == null){
            sharedPreferencesSubComponent = retrofitSubComponent
                    .plusSharedPreferencesSubComponent(new SharedPreferencesModule());

            //sharedPreferencesSubComponent = applicationContextComponent
            //        .plusSharedPreferencesSubComponent(new SharedPreferencesModule());
        }
        return sharedPreferencesSubComponent;
    }

    private void clearSharedPreferencesSubComponent(){
        sharedPreferencesSubComponent = null;
    }

    public RetrofitSubComponent plusRetrofitsubComponent(){
        if(retrofitSubComponent == null){
            retrofitSubComponent = applicationContextComponent
                    .plusRetrofitSubComponent(new RetrofitModule());
        }
        return retrofitSubComponent;
    }

    private void clearRetrofitSubComponent(){
        retrofitSubComponent = null;
    }

    public ApplicationContextComponent getApplicationContextComponent(){
        return applicationContextComponent;
    }


}

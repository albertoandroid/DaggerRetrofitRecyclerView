package com.androiddesdecero.daggerretrofitrecyclerview.di.component;

import android.content.Context;
import android.content.SharedPreferences;

import com.androiddesdecero.daggerretrofitrecyclerview.MainActivity;
import com.androiddesdecero.daggerretrofitrecyclerview.di.module.AdapterModule;
import com.androiddesdecero.daggerretrofitrecyclerview.di.module.ApplicationContextModule;
import com.androiddesdecero.daggerretrofitrecyclerview.di.module.RetrofitModule;
import com.androiddesdecero.daggerretrofitrecyclerview.di.module.SharedPreferencesModule;
import com.androiddesdecero.daggerretrofitrecyclerview.di.scope.ApplicationScope;

import dagger.Component;

/**
 * Created by albertopalomarrobledo on 27/2/19.
 */

@ApplicationScope
@Component(modules = {ApplicationContextModule.class, AdapterModule.class})
public interface ApplicationContextComponent {

    //Context context();

    //void inject(MainActivity mainActivity);


    //SharedPreferencesSubComponent plusSharedPreferencesSubComponent(SharedPreferencesModule sharedPreferencesModule);

    RetrofitSubComponent plusRetrofitSubComponent(RetrofitModule retrofitModule);

}

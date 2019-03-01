package com.androiddesdecero.daggerretrofitrecyclerview.di.module;

import android.content.Context;
import android.content.SharedPreferences;

import com.androiddesdecero.daggerretrofitrecyclerview.di.scope.SharedPreferencesScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by albertopalomarrobledo on 27/2/19.
 */

@Module
public class SharedPreferencesModule {

    public static final String SHARED_PREF = "shared_pref";

    @Provides
    @SharedPreferencesScope
    SharedPreferences providesSharedPreferences(Context context){
        return context.getSharedPreferences("shared_pref", context.MODE_PRIVATE);
    }
}

package com.androiddesdecero.daggerretrofitrecyclerview.di.component;

import com.androiddesdecero.daggerretrofitrecyclerview.MainActivity;
import com.androiddesdecero.daggerretrofitrecyclerview.di.module.RetrofitModule;
import com.androiddesdecero.daggerretrofitrecyclerview.di.module.SharedPreferencesModule;
import com.androiddesdecero.daggerretrofitrecyclerview.di.scope.ActivityScope;

import dagger.Subcomponent;

/**
 * Created by albertopalomarrobledo on 28/2/19.
 */
@ActivityScope
@Subcomponent(modules = RetrofitModule.class)
public interface RetrofitSubComponent {
    void inject(MainActivity mainActivity);

    SharedPreferencesSubComponent plusSharedPreferencesSubComponent(SharedPreferencesModule sharedPreferencesModule);

}

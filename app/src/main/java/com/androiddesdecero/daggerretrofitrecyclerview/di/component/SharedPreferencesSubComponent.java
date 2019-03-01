package com.androiddesdecero.daggerretrofitrecyclerview.di.component;

import com.androiddesdecero.daggerretrofitrecyclerview.Main2Activity;
import com.androiddesdecero.daggerretrofitrecyclerview.MainActivity;
import com.androiddesdecero.daggerretrofitrecyclerview.di.module.SharedPreferencesModule;
import com.androiddesdecero.daggerretrofitrecyclerview.di.scope.SharedPreferencesScope;

import dagger.Subcomponent;

/**
 * Created by albertopalomarrobledo on 27/2/19.
 */
@SharedPreferencesScope
@Subcomponent(modules = SharedPreferencesModule.class)
public interface SharedPreferencesSubComponent {
    void inject(Main2Activity main2Activity);


}

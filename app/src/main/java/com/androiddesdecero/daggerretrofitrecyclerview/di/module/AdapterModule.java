package com.androiddesdecero.daggerretrofitrecyclerview.di.module;

import com.androiddesdecero.daggerretrofitrecyclerview.TiempoAdapter;
import com.androiddesdecero.daggerretrofitrecyclerview.di.scope.ActivityScope;
import com.androiddesdecero.daggerretrofitrecyclerview.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by albertopalomarrobledo on 1/3/19.
 */

@Module
public class AdapterModule {

    @ApplicationScope
    @Provides
    public TiempoAdapter getTiempoAdapter(){
        return new TiempoAdapter();
    }

}

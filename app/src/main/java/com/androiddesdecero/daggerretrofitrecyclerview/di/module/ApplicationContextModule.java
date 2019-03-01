package com.androiddesdecero.daggerretrofitrecyclerview.di.module;

import android.app.Application;
import android.content.Context;

import com.androiddesdecero.daggerretrofitrecyclerview.di.scope.ApplicationScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by albertopalomarrobledo on 27/2/19.
 */

@Module
public class ApplicationContextModule {

    private Application application;

    public ApplicationContextModule(Application application){
        this.application = application;
    }

    @Provides
    @ApplicationScope
    public Application provideApplication(){
        return application;
    }

    @Provides
    @ApplicationScope
    public Context provideApplicationContext(){
        return application.getApplicationContext();
    }
}

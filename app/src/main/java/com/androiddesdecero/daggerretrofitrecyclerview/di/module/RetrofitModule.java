package com.androiddesdecero.daggerretrofitrecyclerview.di.module;

import com.androiddesdecero.daggerretrofitrecyclerview.api.ApiClient;
import com.androiddesdecero.daggerretrofitrecyclerview.di.scope.ActivityScope;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by albertopalomarrobledo on 28/2/19.
 */

@Module
public class RetrofitModule {

    /*
    Grafo de Retrofit
     */
    private static final String BASE_URL = "http://samples.openweathermap.org/";

    @ActivityScope
    @Provides
    GsonConverterFactory provideGsonConverterFactory(){
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();
        return gsonConverterFactory;
    }

    @ActivityScope
    @Provides
    HttpLoggingInterceptor provideHttpLoggingInterceptor(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }

    @ActivityScope
    @Provides
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor){
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    @ActivityScope
    @Provides
    Retrofit provideRetrofit(OkHttpClient client, GsonConverterFactory converterFactory){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(converterFactory)
                .client(client)
                .build();
    }

    @ActivityScope
    @Provides
    ApiClient provideApliClient(Retrofit retrofit){
        return retrofit.create(ApiClient.class);
    }
}

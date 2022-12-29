package com.example.foodapp.di;

import com.example.foodapp.Network.ApiAuthService;
import com.example.foodapp.Network.ApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {
    public final String baseUrl = "https://www.themealdb.com/api/json/v1/1/";
    public final String baseUrlAuth = "https://haji91.000webhostapp.com/Revision/";

    @Provides
    @Singleton
    public ApiService provideMealApiService() {
        return new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build().create(ApiService.class);
    }

    @Provides
    @Singleton
    public ApiAuthService ProvideAuthApiService() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        return new Retrofit.Builder().baseUrl(baseUrlAuth).addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build().create(ApiAuthService.class);
    }

}

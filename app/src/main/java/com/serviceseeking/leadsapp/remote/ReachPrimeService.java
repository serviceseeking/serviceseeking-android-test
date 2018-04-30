package com.serviceseeking.leadsapp.remote;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReachPrimeService {

    public static ReachPrimeApi getClient() {
        HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logger)
//                .addNetworkInterceptor(new LoggingInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://www.mocky.io/v2/")
                .baseUrl("https://staging.serviceseeking.com.au/")
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ReachPrimeApi.class);
    }

}

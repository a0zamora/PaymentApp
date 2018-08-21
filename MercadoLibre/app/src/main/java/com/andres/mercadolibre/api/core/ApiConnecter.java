package com.andres.mercadolibre.api.core;

import com.andres.mercadolibre.BuildConfig;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConnecter {

  private static Retrofit instance;

  static public Retrofit getRetrofit() {
    if (instance == null) {
      HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
      interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
      OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
      instance = new Retrofit.Builder()
          .baseUrl(BuildConfig.CORE_API)
          .addConverterFactory(GsonConverterFactory.create())
          .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
          .client(client)
          .build();
    }
    return instance;
  }
}

package com.gmail.caounn.aries.dagger;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ProjectModule {
  @Singleton
  @Provides Retrofit retrofit(OkHttpClient okHttpClient) {
    return new Retrofit.Builder().baseUrl("http://www.baidu.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
  }

  @Singleton
  @Provides
  OkHttpClient okHttpClient() {
    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    return builder.build();
  }
}

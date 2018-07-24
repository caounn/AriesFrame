package com.gmail.caounn.aries.data.net;

import javax.inject.Inject;
import javax.inject.Singleton;
import retrofit2.Retrofit;

@Singleton
public class Http {

  Api api;

  @Inject Http(Retrofit retrofit) {
    api = retrofit.create(Api.class);
  }

  public void getInfo() {
  }
}

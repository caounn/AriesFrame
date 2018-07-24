package com.gmail.caounn.aries.data.net;

import android.util.Log;
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
    Log.e("error", "1234");
  }
}

package com.gmail.caounn.aries.data.net;

import android.util.Log;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import retrofit2.Retrofit;

/**
 * 接口实现
 */
@Singleton
public class Http implements Api{

  Api api;

  @Inject Http(Retrofit retrofit) {
    Log.e("uri", "123");
    Log.e("uri", retrofit.baseUrl().toString());
    api = retrofit.create(Api.class);
  }

  @Override public Observable<String> login(Map<String, String> obj) {
    return api.login(obj).subscribeOn(Schedulers.io());
  }


}

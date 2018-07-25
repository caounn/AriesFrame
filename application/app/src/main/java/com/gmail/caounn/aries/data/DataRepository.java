package com.gmail.caounn.aries.data;

import android.support.annotation.NonNull;
import com.gmail.caounn.aries.data.bean.LoginBean;
import com.gmail.caounn.aries.data.net.Http;
import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataRepository implements DataSource {
  private Http http;

  @Inject DataRepository(Http http) {
    this.http = http;
  }

  @Override public Observable<LoginBean> login(@NonNull String name, @NonNull String pass) {
    Map<String, String> params = new HashMap<>();
    return http.login(params).flatMap((Function<String, ObservableSource<LoginBean>>) s -> {
      //此处解密，并生成对象
      Gson gson = new Gson();
      if ("0000".equals("")) {
        LoginBean loginBean = new LoginBean();
        return Observable.just(loginBean);
      }
      return Observable.error(new Exception("error"));
    }).observeOn(AndroidSchedulers.mainThread());
  }
}

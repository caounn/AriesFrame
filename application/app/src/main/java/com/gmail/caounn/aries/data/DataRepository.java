package com.gmail.caounn.aries.data;

import android.content.Context;
import android.support.annotation.NonNull;
import com.gmail.caounn.aries.data.bean.LoginBean;
import com.gmail.caounn.aries.data.net.Http;
import com.gmail.caounn.commons.utils.ParamsWrapper;
import com.gmail.caounn.commons.utils.ThreeDes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DataRepository implements DataSource {
  private Http http;
  private Context context;

  @Inject DataRepository(Http http, Context context) {
    this.http = http;
    this.context = context;
  }

  @Override public Observable<LoginBean> login(@NonNull String name, @NonNull String pass) {
    Map<String, String> params = new HashMap<>();
    ParamsWrapper wrapper = new ParamsWrapper(params, context);
    return http.login(wrapper.getRequestParams())
        .flatMap((Function<String, ObservableSource<LoginBean>>) s -> {
          String decode = ThreeDes.decryptByDefaultKey(s);
      Gson gson = new Gson();
          Type type = new TypeToken<LoginBean>() {
          }.getType();
          LoginBean loginBean = gson.fromJson(decode, type);
      if ("0000".equals("")) {
        return Observable.just(loginBean);
      }
      return Observable.error(new Exception("error"));
        });
  }
}

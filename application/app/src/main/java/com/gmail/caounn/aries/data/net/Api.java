package com.gmail.caounn.aries.data.net;

import io.reactivex.Observable;
import java.util.Map;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * 接口
 */
public interface Api {
  @POST("user/login")
  Observable<String> login(@Body Map<String, String> obj);
}

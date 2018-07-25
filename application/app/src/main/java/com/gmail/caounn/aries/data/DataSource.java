package com.gmail.caounn.aries.data;

import android.support.annotation.NonNull;
import com.gmail.caounn.aries.data.bean.LoginBean;
import io.reactivex.Observable;

public interface DataSource {
  Observable<LoginBean> login(@NonNull String name, @NonNull String pass);
}

package com.gmail.caounn.aries.base;

import com.gmail.caounn.aries.dagger.DaggerAppComponent;
import com.gmail.caounn.aries.dagger.ProjectModule;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class AriesApplication extends DaggerApplication {
  @Override public void onCreate() {
    super.onCreate();
  }

  @Override protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
    return DaggerAppComponent.builder()
        .application(this)
        .projectModule(new ProjectModule("https://www.baidu.com"))
        .build();
  }
}

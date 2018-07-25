package com.gmail.caounn.aries.base;

import android.util.Log;
import com.gmail.caounn.aries.BuildConfig;
import com.gmail.caounn.aries.dagger.DaggerAppComponent;
import com.gmail.caounn.aries.dagger.ProjectModule;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.smtt.sdk.QbSdk;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class AriesApplication extends DaggerApplication {
  @Override public void onCreate() {
    super.onCreate();
    CrashReport.initCrashReport(this, BuildConfig.Bugly_Id, false);
    QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
      @Override public void onCoreInitFinished() {

      }

      @Override public void onViewInitFinished(boolean b) {
        Log.d("app", " onViewInitFinished is " + b);
      }
    };
    QbSdk.initX5Environment(this, cb);
  }

  @Override protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
    return DaggerAppComponent.builder()
        .application(this)
        .projectModule(new ProjectModule(BuildConfig.Api_Uri))
        .build();
  }
}

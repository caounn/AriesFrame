package com.gmail.caounn.aries.utils;

import android.content.Context;
import android.content.SharedPreferences;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AriesPreference {
  SharedPreferences preferences;

  @Inject AriesPreference(Context context) {
    preferences = context.getSharedPreferences("", Context.MODE_PRIVATE);
  }

}

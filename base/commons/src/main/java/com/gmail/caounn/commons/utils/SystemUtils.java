package com.gmail.caounn.commons.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

public class SystemUtils {
  /**
   * dp to px
   */
  public static float dp2px(Context context, float dpValue) {
    float scale = context.getResources().getDisplayMetrics().density;
    return dpValue * scale + 0.5f;
  }

  /**
   * px to dp
   */
  public static float px2dp(Context context, float pxValue) {
    float scale = context.getResources().getDisplayMetrics().density;
    return pxValue / scale + 0.5f;
  }

  /**
   * app version name
   */
  public static String getAppVersionName(Context context) {
    try {
      PackageInfo packageInfo =
          context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
      return packageInfo.versionName;
    } catch (PackageManager.NameNotFoundException e) {
      return "未知版本";
    }
  }

  /**
   * system version
   */
  public static String getSystemVersion() {
    return Build.VERSION.RELEASE;
  }

  /**
   * os name
   */
  public static String getOsName() {
    return Build.MODEL;
  }
}

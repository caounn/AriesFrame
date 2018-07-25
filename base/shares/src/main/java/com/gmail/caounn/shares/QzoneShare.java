package com.gmail.caounn.shares;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.connect.share.QQShare;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;

/**
 * Created by cao-q on 2017/12/5.
 */

public class QzoneShare {
  public static void shareToQQ(Tencent tencent, Activity activity, String title, String description,
      String webUrl, String imgUrl, IUiListener iUiListener) {
    Bundle params = new Bundle();
    params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
    params.putString(QQShare.SHARE_TO_QQ_TITLE, title);
    params.putString(QQShare.SHARE_TO_QQ_SUMMARY, description);
    params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, webUrl);
    params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL,
        imgUrl);
    tencent.shareToQQ(activity, params, iUiListener);
  }

  public static void shareToQzone(Tencent tencent, Activity activity, String title,
      String description,
      String webUrl, String imgUrl, IUiListener iUiListener) {
    Bundle params = new Bundle();
    params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
    params.putString(QQShare.SHARE_TO_QQ_TITLE, title);
    params.putString(QQShare.SHARE_TO_QQ_SUMMARY, description);
    params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, webUrl);
    params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL,
        imgUrl);
    tencent.shareToQzone(activity, params, iUiListener);
  }
}

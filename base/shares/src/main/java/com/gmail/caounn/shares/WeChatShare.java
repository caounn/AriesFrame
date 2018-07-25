package com.gmail.caounn.shares;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import com.gmail.caounn.shares.utils.Util;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import java.io.File;

/**
 * Created by cao-q on 2017/12/5.
 */

public class WeChatShare {
  private static final int THUMB_SIZE = 150;

  public static void share(IWXAPI iwxapi, int scene, String title, String description,
      String webUrl, String imgUrl) {
    if (!TextUtils.isEmpty(webUrl)) {
      sendWebToWx(iwxapi, scene, title, description, webUrl, imgUrl);
    }
    if (!TextUtils.isEmpty(imgUrl)) {
      sendImgToWx(iwxapi, scene, imgUrl);
      return;
    }
    if (!TextUtils.isEmpty(title)) {
      sendTxtToWx(iwxapi, scene, title);
      return;
    }
  }

  /**
   * 分享文字到微信
   */
  private static void sendTxtToWx(IWXAPI api, int scene, String text) {
    WXTextObject textObj = new WXTextObject();
    textObj.text = text;
    WXMediaMessage msg = new WXMediaMessage();
    msg.mediaObject = textObj;
    msg.description = text;
    SendMessageToWX.Req req = new SendMessageToWX.Req();
    req.transaction = buildTransaction("text");
    req.message = msg;
    req.scene = scene;
    api.sendReq(req);
  }

  private static void sendWebToWx(IWXAPI api, int scene, String title, String description,
      String url, String imgUrl) {
    WXWebpageObject webpage = new WXWebpageObject();
    webpage.webpageUrl = url;
    WXMediaMessage msg = new WXMediaMessage(webpage);
    msg.title = title;
    msg.description = description;
    Bitmap bmp = Util.getImage(imgUrl);
    if (bmp != null) {
      Bitmap thumbBmp = Bitmap.createScaledBitmap(bmp, THUMB_SIZE, THUMB_SIZE, true);
      bmp.recycle();
      msg.thumbData = Util.bmpToByteArray(thumbBmp, true);
    }
    SendMessageToWX.Req req = new SendMessageToWX.Req();
    req.transaction = buildTransaction("webpage");
    req.message = msg;
    req.scene = scene;
    api.sendReq(req);
  }

  private static void sendImgToWx(IWXAPI api, int scene, String ImgUrl) {

    File file = new File(ImgUrl);
    if (!file.exists()) {
      if (BuildConfig.DEBUG) {
        Log.e("share library", "imgpath is no a image");
      }
      return;
    }
    WXImageObject imgObj = new WXImageObject();
    imgObj.setImagePath(ImgUrl);
    WXMediaMessage msg = new WXMediaMessage();
    msg.mediaObject = imgObj;

    Bitmap bmp = Util.getImage(ImgUrl);
    if (bmp != null) {
      Bitmap thumbBmp = Bitmap.createScaledBitmap(bmp, THUMB_SIZE, THUMB_SIZE, true);
      bmp.recycle();
      msg.thumbData = Util.bmpToByteArray(thumbBmp, true);
    }
    SendMessageToWX.Req req = new SendMessageToWX.Req();
    req.transaction = buildTransaction("img");
    req.message = msg;
    req.scene = scene;
    api.sendReq(req);
  }

  private static String buildTransaction(final String type) {
    return (type == null) ? String.valueOf(System.currentTimeMillis())
        : type + System.currentTimeMillis();
  }
}

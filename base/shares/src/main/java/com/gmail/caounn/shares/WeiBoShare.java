package com.gmail.caounn.shares;

import android.graphics.Bitmap;
import com.gmail.caounn.shares.utils.Util;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.share.WbShareHandler;
import com.sina.weibo.sdk.utils.Utility;

/**
 * Created by cao-q on 2017/12/5.
 */

public class WeiBoShare {
  private static final int THUMB_SIZE = 150;

  public static void share(WbShareHandler shareHandler, String title, String description,
      String webUrl, String imgUrl) {
    WeiboMultiMessage weiboMessage = new WeiboMultiMessage();
    if (webUrl != null) {
      weiboMessage.mediaObject = getWebpageObj(title, description, webUrl, imgUrl);
      shareHandler.shareMessage(weiboMessage, false);
      return;
    }
    if (imgUrl != null) {
      weiboMessage.imageObject = getImageObj(imgUrl);
      shareHandler.shareMessage(weiboMessage, false);
      return;
    }
    weiboMessage.textObject = getTextObj(title, description);
    shareHandler.shareMessage(weiboMessage, false);
  }

  /**
   * 创建文本消息对象。
   *
   * @return 文本消息对象。
   */
  private static TextObject getTextObj(String title, String description) {
    TextObject textObject = new TextObject();
    textObject.text = description;
    textObject.title = title;
    return textObject;
  }

  /**
   * 创建图片消息对象。
   *
   * @return 图片消息对象。
   */
  private static ImageObject getImageObj(String imagurl) {
    ImageObject imageObject = new ImageObject();
    Bitmap bmp = Util.getImage(imagurl);
    if (bmp != null) {
      imageObject.setImageObject(bmp);
    }
    return imageObject;
  }

  /**
   * 创建多媒体（网页）消息对象。
   *
   * @return 多媒体（网页）消息对象。
   */
  private static WebpageObject getWebpageObj(String title, String description,
      String webUrl, String imgUrl) {
    WebpageObject mediaObject = new WebpageObject();
    mediaObject.identify = Utility.generateGUID();
    mediaObject.title = title;
    mediaObject.description = description;
    Bitmap bmp = Util.getImage(imgUrl);
    if (bmp != null) {
      Bitmap thumbBmp = Bitmap.createScaledBitmap(bmp, THUMB_SIZE, THUMB_SIZE, true);
      bmp.recycle();
      mediaObject.setThumbImage(thumbBmp);
    }
    mediaObject.actionUrl = webUrl;
    mediaObject.defaultText = title;
    return mediaObject;
  }
}

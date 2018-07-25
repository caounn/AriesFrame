package com.gmail.caounn.shares;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.sina.weibo.sdk.share.WbShareHandler;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;

/**
 * Created by cao-q on 2017/12/5.
 */

public class ShareUtil {
  public static final String REDIRECT_URL = "http://www.baidu.com";
  private String title;
  private String description;
  private String webUrl;
  private String imgUrl;
  private Activity activity;
  private String type;

  private ShareUtil() {
  }

  private ShareUtil(ShareUtil shareUtil) {
    this.title = shareUtil.title;
    this.description = shareUtil.description;
    this.webUrl = shareUtil.webUrl;
    this.imgUrl = shareUtil.imgUrl;
    this.type = shareUtil.type;
    this.activity = shareUtil.activity;
    IWXAPI api = WXAPIFactory.createWXAPI(activity, null);
    //api.registerApp(BuildConfig.WECHAT_ID);
    //WbSdk.install(activity,new AuthInfo(activity,BuildConfig.WEIBO_ID, REDIRECT_URL, "email"));
  }

  public void share() {
    if (activity == null) {
      if (BuildConfig.DEBUG) {
        Log.e("share library", "context cannot be null!");
      }
      return;
    }
    switch (type) {
      case "QQ":
        //Tencent tencent = Tencent.createInstance(BuildConfig.QZONE_ID, activity);
        //QzoneShare.shareToQQ(tencent, activity, title, description, webUrl, imgUrl,
        //    new ShareListener(){
        //      @Override public void onComplete(Object o) {
        //        super.onComplete(o);
        //      }
        //
        //      @Override public void onError(UiError uiError) {
        //        super.onError(uiError);
        //        Log.e("error",""+uiError.errorMessage);
        //      }
        //
        //      @Override public void onCancel() {
        //        super.onCancel();
        //      }
        //    });
        break;
      case "WEIBO":

        WbShareHandler shareHandler = new WbShareHandler(activity);
        shareHandler.registerApp();
        WeiBoShare.share(shareHandler, title, description, webUrl, imgUrl);
        break;
      case "QZONE":
        //Tencent qzone = Tencent.createInstance(BuildConfig.QZONE_ID, activity);
        //QzoneShare.shareToQzone(qzone, activity, title, description, webUrl, imgUrl,
        //    new ShareListener());
        break;
      case "WECHAT":
        //IWXAPI iwxapi = WXAPIFactory.createWXAPI(activity, BuildConfig.WECHAT_ID);
        //int WeChatScene = SendMessageToWX.Req.WXSceneSession;
        //WeChatShare.share(iwxapi, WeChatScene, title, description, webUrl, imgUrl);
        break;
      case "CIRCLE":
        //IWXAPI api = WXAPIFactory.createWXAPI(activity, BuildConfig.WECHAT_ID);
        //int CircleScene = SendMessageToWX.Req.WXSceneTimeline;
        //WeChatShare.share(api, CircleScene, title, description, webUrl, imgUrl);
        break;
      case "SMS":
        Uri smstoUri = Uri.parse("smsto:");
        Intent intent = new Intent(Intent.ACTION_SENDTO, smstoUri);
        intent.putExtra("sms_body", "短信内容");
        activity.startActivity(intent);
        break;
    }
  }

  public static class Builder {

    private ShareUtil shareUtil;

    public Builder() {
      shareUtil = new ShareUtil();
    }

    public Builder title(String title) {
      shareUtil.title = title;
      return this;
    }

    public Builder description(String description) {
      shareUtil.description = description;
      return this;
    }

    public Builder webUrl(String webUrl) {
      shareUtil.webUrl = webUrl;
      return this;
    }

    public Builder imgUrl(String imgUrl) {
      shareUtil.imgUrl = imgUrl;
      return this;
    }

    public Builder activity(Activity activity) {
      shareUtil.activity = activity;
      return this;
    }

    public Builder type(String type) {
      shareUtil.type = type;
      return this;
    }

    public ShareUtil build() {

      return new ShareUtil(shareUtil);
    }
  }

  class ShareListener implements IUiListener {
    @Override public void onComplete(Object o) {

    }

    @Override public void onError(UiError uiError) {

    }

    @Override public void onCancel() {

    }
  }
}

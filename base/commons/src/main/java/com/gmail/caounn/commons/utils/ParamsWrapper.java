package com.gmail.caounn.commons.utils;

import android.content.Context;
import com.google.gson.Gson;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * <Pre>
 * 请求参数封装
 * </Pre>
 *
 * @author baoy
 * @version 1.0
 * create by 15/7/16 下午2:38
 */
public class ParamsWrapper {

  public final static String tf = "yyyyMMddHHmmss";
  protected String appsecret;
  protected String timestamp;
  protected String version;
  protected String appversion;
  protected String imei;
  protected String model;
  protected String channel;
  protected Map<String, String> data;

  public ParamsWrapper(Map<String, String> data, Context context) {

    this.appsecret = "cqcmcc@asiainfo";
    this.timestamp = getRequestTime();
    this.appversion = String.valueOf(SystemUtils.getAppVersionName(context));
    this.version = "1.0";
    this.channel = "1";
    this.model = SystemUtils.getOsName();
    this.imei = Installation.id(context);
    this.data = data;
  }

  private static String getRequestTime() {
    Calendar cal = new GregorianCalendar();
    Date date = cal.getTime();
    DateFormat format = new SimpleDateFormat(tf);
    return format.format(date);
  }

  /**
   * 组装Post请求参数,包含请求头及数据体
   */
  public Map<String, String> getRequestParams() {
    Map<String, String> params = new HashMap<>();
    params.put("appsecret", appsecret);
    params.put("timestamp", timestamp);
    params.put("version", version);
    params.put("appversion", appversion);
    params.put("imei", imei);
    params.put("model", model);
    params.put("channel", channel);
    if (data != null) {
      for (String key : data.keySet()) {
        if (null != data.get(key)) {
          params.put(key, data.get(key));
        }
      }
    }
    String sign = SignUtil.sign(params, appsecret);
    params.put("sign", sign);
    Map<String, String> param = new HashMap<>();
    param.put("msg", ThreeDes.encryptByDefaultSecretKey(toJsonString(params)));
    return param;
  }

  private String toJsonString(Object obj) {
    Gson gson = new Gson();
    return gson.toJson(obj);
  }
}

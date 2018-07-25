package com.gmail.caounn.commons.utils;

import android.util.Base64;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

/**
 * 3DES加密
 */
public class ThreeDes {
  private static final String DEFAULT_SECRET_KEY =
      "HEGAOXIAODANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAocbCrurZGbC5GArEHKlAfDSZi7gFBnd4yxOt0rwTqKBFzGyhtQLu5PRKjEiOXVa95aeIIBJ6OhC2f8FjqFUpawIDAQABAkAPejKaBYHrwUqUEEOe8lpnB6lBAsQIUFnQI";

  private static final String CHARSET_UTF_8 = "UTF-8";

  public static String encryptByDefaultSecretKey(String src) {
    return encrypt(src, DEFAULT_SECRET_KEY);
  }

  public static String encrypt(String src, String key)// 3DESECB加密,key必须是长度大于等于 3*8 = 24 位
  {
    byte[] b = null;
    try {
      src = Base64.encode(src.getBytes(CHARSET_UTF_8), Base64.DEFAULT).toString();

      KeySpec dks = new DESedeKeySpec(key.getBytes(CHARSET_UTF_8));

      SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");

      SecretKey securekey = keyFactory.generateSecret(dks);

      Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
      cipher.init(Cipher.ENCRYPT_MODE, securekey);
      b = cipher.doFinal(src.getBytes(CHARSET_UTF_8));
    } catch (Exception e) {
      return null;
    }

    return Base64.encodeToString(b, Base64.DEFAULT).replaceAll("\r|\n", "");
  }

  public static String decryptByDefaultKey(String src) {
    return decrypt(src, DEFAULT_SECRET_KEY);
  }

  public static String decrypt(String src, String key)// 3DESECB解密,key必须是长度大于等于 3*8 = 24 位
  {
    if (src == null) {
      return null;
    }

    byte[] retByte = null;
    try {
      byte[] decodeBytes = Base64.decode(src, Base64.DEFAULT);

      KeySpec dks = new DESedeKeySpec(key.getBytes(CHARSET_UTF_8));
      SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
      SecretKey securekey = keyFactory.generateSecret(dks);

      Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
      cipher.init(Cipher.DECRYPT_MODE, securekey);
      retByte = cipher.doFinal(decodeBytes);

      retByte = Base64.decode(new String(retByte, CHARSET_UTF_8), Base64.DEFAULT);

      return new String(retByte, CHARSET_UTF_8);
    } catch (Exception e) {
      return null;
    }
  }
}

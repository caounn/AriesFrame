package com.gmail.caounn.aries.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.gmail.caounn.aries.R;

public class LoadActivity extends AppCompatActivity {
  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_load);
    TextView version = findViewById(R.id.version);
    version.setText("model:" + Build.MODEL + "\r\n");
    version.append("device:" + Build.DEVICE + "\r\n");
    version.append("base_os:" + Build.VERSION.BASE_OS + "\r\n");
    version.append("codeName:" + Build.VERSION.CODENAME + "\r\n");
    version.append("incremental:" + Build.VERSION.INCREMENTAL + "\r\n");
    version.append("release:" + Build.VERSION.RELEASE + "\r\n");
    version.append("security_patch:" + Build.VERSION.SECURITY_PATCH + "\r\n");
    version.append("sdk_int:" + Build.VERSION.SDK_INT + "\r\n");
    version.append("id:" + Build.ID + "\r\n");
    version.append("board:" + Build.BOARD + "\r\n");
    version.append("product:" + Build.PRODUCT + "\r\n");
    version.append("bootloader:" + Build.BOOTLOADER + "\r\n");
    version.append("brand:" + Build.BRAND + "\r\n");
    version.append("hardware:" + Build.HARDWARE + "\r\n");
    version.append("display:" + Build.DISPLAY + "\r\n");
    version.append("user:" + Build.USER + "\r\n");
    version.append("type:" + Build.TYPE + "\r\n");
    version.append("tags:" + Build.TAGS + "\r\n");
    version.append("manufacturer:" + Build.MANUFACTURER + "\r\n");
    version.append("host:" + Build.HOST + "\r\n");
    version.append("fingerprint:" + Build.FINGERPRINT + "\r\n");





  }
}

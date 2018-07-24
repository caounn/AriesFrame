package com.gmail.caounn.aries.ui.load;

import android.support.annotation.Nullable;
import com.gmail.caounn.aries.data.net.Http;
import javax.inject.Inject;

public class LoadPresenter implements LoadContract.Presenter {
  @Nullable
  private LoadContract.View loadView;
  Http http;

  @Inject LoadPresenter(Http http) {
    this.http = http;
  }

  private void getMsg() {
    http.getInfo();
    this.loadView.showError();
  }

  @Override public void takeView(LoadContract.View view) {
    this.loadView = view;
    getMsg();
  }

  @Override public void dropView() {
    this.loadView = null;
  }
}

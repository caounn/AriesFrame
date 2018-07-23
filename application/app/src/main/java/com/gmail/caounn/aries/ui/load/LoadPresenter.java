package com.gmail.caounn.aries.ui.load;

import android.support.annotation.Nullable;
import javax.inject.Inject;

public class LoadPresenter implements LoadContract.Presenter {
  @Nullable
  private LoadContract.View loadView;

  @Inject LoadPresenter() {
  }

  private void getMsg() {
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

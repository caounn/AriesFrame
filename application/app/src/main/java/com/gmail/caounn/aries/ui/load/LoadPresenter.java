package com.gmail.caounn.aries.ui.load;

import android.support.annotation.Nullable;
import com.gmail.caounn.aries.data.DataSource;
import javax.inject.Inject;

public class LoadPresenter implements LoadContract.Presenter {
  @Nullable
  private LoadContract.View loadView;
  DataSource repository;

  @Inject LoadPresenter(DataSource repository) {
    this.repository = repository;
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

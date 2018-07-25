package com.gmail.caounn.aries.ui.load;

import android.support.annotation.Nullable;
import com.gmail.caounn.aries.data.DataRepository;
import javax.inject.Inject;

public class LoadPresenter implements LoadContract.Presenter {
  @Nullable
  private LoadContract.View loadView;
  DataRepository repository;

  @Inject LoadPresenter(DataRepository repository) {
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

package com.gmail.caounn.aries.ui.load;

import android.support.annotation.Nullable;
import com.gmail.caounn.aries.data.DataSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import javax.inject.Inject;

public class LoadPresenter implements LoadContract.Presenter {
  @Nullable
  private LoadContract.View loadView;
  DataSource dataSource;
  Disposable disposable;

  @Inject LoadPresenter(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override public void takeView(LoadContract.View view) {
    this.loadView = view;
  }

  @Override public void initApp() {
    disposable = dataSource.login("", "").observeOn(AndroidSchedulers.mainThread()).subscribe(v -> {

    }, error -> {
      loadView.showError();
    });
  }

  @Override public void dropView() {
    this.loadView = null;
    if (disposable != null && !disposable.isDisposed()) {
      disposable.dispose();
    }
  }
}

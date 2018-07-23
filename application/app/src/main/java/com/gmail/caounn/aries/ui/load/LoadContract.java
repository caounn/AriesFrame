package com.gmail.caounn.aries.ui.load;

import com.gmail.caounn.aries.base.BasePresenter;
import com.gmail.caounn.aries.base.BaseView;

public interface LoadContract {
  interface View extends BaseView<Presenter> {
    void showError();
  }

  interface Presenter extends BasePresenter<View> {

  }
}

package com.gmail.caounn.aries.ui.load;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.gmail.caounn.aries.R;
import com.gmail.caounn.aries.base.BaseActivity;
import javax.inject.Inject;

public class LoadActivity extends BaseActivity implements LoadContract.View {
  @Inject
  LoadContract.Presenter loadPresenter;
  @BindView(R.id.img) ImageView img;

  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_load);
    ButterKnife.bind(this);
    loadPresenter.takeView(this);
  }

  @Override public void showError() {

  }
}

package com.gmail.caounn.aries.ui.load;

import com.gmail.caounn.aries.dagger.ActivityScoped;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class LoadModule {

  @ActivityScoped
  @Binds
  abstract LoadContract.Presenter loadPresenter(LoadPresenter presenter);
}

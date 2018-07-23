package com.gmail.caounn.aries.dagger;

import com.gmail.caounn.aries.ui.ad.AdActivity;
import com.gmail.caounn.aries.ui.load.LoadActivity;
import com.gmail.caounn.aries.ui.load.LoadModule;
import com.gmail.caounn.aries.ui.main.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModlue {
  @ActivityScoped
  @ContributesAndroidInjector
  abstract AdActivity adActivity();

  @ActivityScoped
  @ContributesAndroidInjector
  abstract MainActivity mainActivity();

  @ActivityScoped
  @ContributesAndroidInjector(modules = LoadModule.class)
  abstract LoadActivity loadActivity();
}

package com.gmail.caounn.aries.dagger;

import android.app.Application;
import com.gmail.caounn.aries.base.AriesApplication;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import javax.inject.Singleton;

@Singleton
@Component(modules = {
    ApplicationModule.class,
    ActivityBindingModlue.class,
    AndroidSupportInjectionModule.class
})
public interface AppComponent extends AndroidInjector<AriesApplication> {

  @Component.Builder interface Builder {

    @BindsInstance
    AppComponent.Builder application(Application application);

    AppComponent build();
  }
}

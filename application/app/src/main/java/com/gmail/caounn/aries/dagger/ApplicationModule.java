package com.gmail.caounn.aries.dagger;

import android.app.Application;
import android.content.Context;
import com.gmail.caounn.aries.data.DataRepository;
import com.gmail.caounn.aries.data.DataSource;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class ApplicationModule {
  @Binds
  abstract Context bindContext(Application application);

  @Binds
  abstract DataSource dataSource(DataRepository repository);
}

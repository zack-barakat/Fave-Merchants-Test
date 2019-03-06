package com.android.favemerchants.di.component;

import android.app.Application;
import android.content.Context;
import com.android.favemerchants.App;
import com.android.favemerchants.data.IAppErrorHelper;
import com.android.favemerchants.data.IDataManager;
import com.android.favemerchants.di.module.ApiModule;
import com.android.favemerchants.di.module.ApplicationModule;
import com.android.favemerchants.di.module.DataManagerModule;
import com.android.favemerchants.di.qualifiers.ApplicationContext;
import com.android.favemerchants.di.scopes.ApplicationScope;
import dagger.BindsInstance;
import dagger.Component;

@ApplicationScope
@Component(modules = {
        DataManagerModule.class,
        ApiModule.class,
        ApplicationModule.class})
public interface ApplicationComponent {

    void inject(App app);

    @ApplicationContext
    Context context();

    Application application();

    IDataManager getDataManager();

    IAppErrorHelper getErrorHelper();

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }
}
package com.android.favemerchants.di.component;

import android.app.Application;
import android.content.Context;
import com.android.favemerchants.App;
import com.android.favemerchants.data.IAppErrorHelper;
import com.android.favemerchants.data.IDataManager;
import com.android.favemerchants.di.qualifiers.ApplicationContext;

public interface ApplicationComponent {

    void inject(App app);

    @ApplicationContext
    Context context();

    Application application();

    IDataManager getDataManager();

    IAppErrorHelper getErrorHelper();
}
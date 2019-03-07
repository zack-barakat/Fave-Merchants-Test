package com.android.favemerchants.di.component;


import com.android.favemerchants.di.module.ActivityModule;
import com.android.favemerchants.di.scopes.ActivityScope;
import com.android.favemerchants.ui.base.BaseMvpActivity;
import com.android.favemerchants.ui.favemerchants.FaveMerchantsActivity;
import com.android.favemerchants.ui.splash.SplashActivity;
import dagger.Component;


@ActivityScope
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(BaseMvpActivity activity);

    void inject(SplashActivity activity);

    void inject(FaveMerchantsActivity activity);
}
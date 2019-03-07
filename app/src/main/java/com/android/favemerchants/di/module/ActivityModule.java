package com.android.favemerchants.di.module;

import android.app.Activity;
import android.content.Context;
import com.android.favemerchants.di.qualifiers.ActivityContext;
import com.android.favemerchants.ui.favemerchants.FaveMerchantsContracts;
import com.android.favemerchants.ui.favemerchants.FaveMerchantsPresenter;
import com.android.favemerchants.ui.searchmerchants.MerchantsSearchContracts;
import com.android.favemerchants.ui.searchmerchants.MerchantsSearchPresenter;
import com.android.favemerchants.ui.splash.SplashContracts;
import com.android.favemerchants.ui.splash.SplashPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

    @Provides
    Activity provideActivity() {
        return activity;
    }

    @Provides
    SplashContracts.Presenter<SplashContracts.View> provideSplashPresenter(SplashPresenter splashPresenter) {
        return splashPresenter;
    }

    @Provides
    FaveMerchantsContracts.Presenter<FaveMerchantsContracts.View> provideFaveMerchantsPresenter(FaveMerchantsPresenter faveMerchantsPresenter) {
        return faveMerchantsPresenter;
    }

    @Provides
    MerchantsSearchContracts.Presenter<MerchantsSearchContracts.View> provideMerchantsSearchPresenter(MerchantsSearchPresenter merchantsSearchPresenter) {
        return merchantsSearchPresenter;
    }
}

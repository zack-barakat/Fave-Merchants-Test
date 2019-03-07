package com.android.favemerchants.di.component;

import android.app.Application;
import com.android.favemerchants.di.module.MockApiModule;
import com.android.favemerchants.di.module.TestApplicationModule;
import com.android.favemerchants.di.module.TestDataManagerModule;
import com.android.favemerchants.di.scopes.ApplicationScope;
import com.android.favemerchants.mvp.FaveMerchantsPresenterTest;
import com.android.favemerchants.mvp.MerchantsSearchPresenterTest;
import com.android.favemerchants.testCase.AppRobolectricTestCase;
import dagger.BindsInstance;
import dagger.Component;

@ApplicationScope
@Component(modules = {
        TestDataManagerModule.class,
        MockApiModule.class,
        TestApplicationModule.class})
public interface TestApplicationComponent extends FlavorComponent {

    void inject(AppRobolectricTestCase appRobolectricTestCase);

    void inject(FaveMerchantsPresenterTest faveMerchantsPresenterTest);

    void inject(MerchantsSearchPresenterTest merchantsSearchPresenterTest);

    @Component.Builder
    interface Builder {
        @BindsInstance
        TestApplicationComponent.Builder application(Application application);

        TestApplicationComponent build();
    }
}

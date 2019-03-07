package com.android.favemerchants.di.component;


import android.app.Application;
import com.android.favemerchants.data.repositories.IFaveMerchantRepository;
import com.android.favemerchants.di.module.ApiModule;
import com.android.favemerchants.di.module.ApplicationModule;
import com.android.favemerchants.di.module.MockDataManagerModule;
import com.android.favemerchants.di.scopes.ApplicationScope;
import dagger.BindsInstance;
import dagger.Component;


@ApplicationScope
@Component(modules = {MockDataManagerModule.class,
        ApplicationModule.class, ApiModule.class})
public interface ApplicationMockComponent extends FlavorComponent {

    IFaveMerchantRepository getFaveMerchantRepository();


    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        ApplicationMockComponent build();
    }
}
package com.android.favemerchants.di.module;

import com.android.favemerchants.data.AppErrorHelper;
import com.android.favemerchants.data.DataManager;
import com.android.favemerchants.data.IAppErrorHelper;
import com.android.favemerchants.data.IDataManager;
import com.android.favemerchants.data.repositories.FaveMerchantRepository;
import com.android.favemerchants.data.repositories.IFaveMerchantRepository;
import com.android.favemerchants.di.scopes.ApplicationScope;
import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.spy;


@Module
public class TestDataManagerModule {

    @Provides
    @ApplicationScope
    IDataManager provideIAppDataManager(DataManager testDataManager) {
        return spy(testDataManager);
    }

    @Provides
    @ApplicationScope
    IFaveMerchantRepository provideIFaveMerchantRepository(FaveMerchantRepository faveMerchantRepository) {
        return spy(faveMerchantRepository);
    }

    @Provides
    @ApplicationScope
    IAppErrorHelper provideIAppErrorHelper(AppErrorHelper errorHelper) {
        return spy(errorHelper);
    }
}

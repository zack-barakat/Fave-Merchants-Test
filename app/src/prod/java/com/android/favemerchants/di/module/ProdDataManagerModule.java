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

/**
 * Created by zack_barakat
 */

@Module(includes = ApiModule.class)
public class ProdDataManagerModule {

    @Provides
    @ApplicationScope
    public IDataManager provideDataManager(DataManager manager) {
        return manager;
    }

    @Provides
    @ApplicationScope
    public IAppErrorHelper provideErrorHelper(AppErrorHelper errorHelper) {
        return errorHelper;
    }


    @Provides
    @ApplicationScope
    public IFaveMerchantRepository provideFaveMerchantRepository(FaveMerchantRepository faveMerchantRepository) {
        return faveMerchantRepository;
    }
}

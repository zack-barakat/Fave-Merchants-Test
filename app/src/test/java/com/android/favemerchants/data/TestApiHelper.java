package com.android.favemerchants.data;

import com.android.favemerchants.data.model.Merchant;
import com.android.favemerchants.data.network.IApiHelper;
import com.android.favemerchants.di.scopes.ApplicationScope;
import com.android.favemerchants.testUtils.TestDataGenerator;
import io.reactivex.Observable;

import java.util.ArrayList;


@ApplicationScope
public class TestApiHelper implements IApiHelper {

    @Override
    public Observable<ArrayList<Merchant>> getFaveMerchants() {
        return Observable.just(TestDataGenerator.getMerchants());
    }
}

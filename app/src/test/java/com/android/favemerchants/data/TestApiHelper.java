package com.android.favemerchants.data;

import com.android.favemerchants.data.model.MerchantsResponse;
import com.android.favemerchants.data.network.IApiHelper;
import com.android.favemerchants.di.scopes.ApplicationScope;
import com.android.favemerchants.testUtils.TestDataGenerator;
import io.reactivex.Observable;


@ApplicationScope
public class TestApiHelper implements IApiHelper {

    @Override
    public Observable<MerchantsResponse> getFaveMerchants(int from, int size) {
        return Observable.just(TestDataGenerator.Companion.getMerchantsResponse());
    }

    @Override
    public Observable<MerchantsResponse> searchForFaveMerchants(String query) {
        return Observable.just(TestDataGenerator.Companion.getMerchantsResponse());
    }
}

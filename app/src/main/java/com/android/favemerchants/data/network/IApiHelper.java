package com.android.favemerchants.data.network;

import com.android.favemerchants.data.model.Merchant;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.http.GET;

import java.util.ArrayList;

/**
 * Created by zack_barakat
 */

public interface IApiHelper {


    @GET("merchants")
    Observable<ArrayList<Merchant>> getFaveMerchants();

    class Factory {
        public static final int NETWORK_CALL_TIMEOUT = 30;

        public static IApiHelper create(Retrofit retrofit) {

            return retrofit.create(IApiHelper.class);
        }
    }
}

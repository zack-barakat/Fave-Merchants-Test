package com.android.favemerchants.data.network;

import com.android.favemerchants.data.model.MerchantsResponse;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zack_barakat
 */

public interface IApiHelper {


    @GET("merchants_index/merchants/_search?from=0&size=20")
    Observable<MerchantsResponse> getFaveMerchants(@Query("from") int from, @Query("size") int size);

    @GET("merchants_index/merchants/_search?from=0&size=20")
    Observable<MerchantsResponse> searchForFaveMerchants(@Query("q") String query);

    class Factory {
        public static final int NETWORK_CALL_TIMEOUT = 30;

        public static IApiHelper create(Retrofit retrofit) {

            return retrofit.create(IApiHelper.class);
        }
    }
}

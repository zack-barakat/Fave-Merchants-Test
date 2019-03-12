package com.android.favemerchants.data.repositories

import com.android.favemerchants.data.TestDataGenerator
import com.android.favemerchants.data.model.Merchant
import com.android.favemerchants.data.network.IApiHelper
import com.android.favemerchants.di.scopes.ApplicationScope
import io.reactivex.Observable
import javax.inject.Inject


@ApplicationScope
open class FakeFaveMerchantRepository @Inject constructor(private val apiHelper: IApiHelper) : IFaveMerchantRepository {

    private var mFaveMerchants = TestDataGenerator.getMerchantArrayList()

    /**
     * get the list of fave merchants and persist them in memory
     * @return list of fave merchants
     */
    override fun getMerchants(from: Int, size: Int): Observable<ArrayList<Merchant>> {
        return Observable.just(mFaveMerchants)
    }

    /**
     * search for list of fave merchants that contains the query
     * @return list of fave merchants
     */
    override fun getMerchants(query: String): Observable<ArrayList<Merchant>> {
        return Observable.just(mFaveMerchants)
            .map { merchants -> merchants.filter { it.name.contains(query, true) } }
            .map { ArrayList(it) }
    }
}
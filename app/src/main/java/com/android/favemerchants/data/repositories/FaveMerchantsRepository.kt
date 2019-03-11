package com.android.favemerchants.data.repositories

import com.android.favemerchants.data.model.Merchant
import com.android.favemerchants.data.network.IApiHelper
import com.android.favemerchants.di.scopes.ApplicationScope
import io.reactivex.Observable
import javax.inject.Inject


interface IFaveMerchantRepository {
    fun getMerchants(from: Int, size: Int): Observable<ArrayList<Merchant>>

    fun getMerchants(query: String): Observable<ArrayList<Merchant>>
}

@ApplicationScope
open class FaveMerchantRepository @Inject constructor(private val apiHelper: IApiHelper) : IFaveMerchantRepository {

    private var mFaveMerchants = arrayListOf<Merchant>()

    /**
     * get the list of fave merchants and persist them in memory
     * @return list of fave merchants
     */
    override fun getMerchants(from: Int, size: Int): Observable<ArrayList<Merchant>> {
        return apiHelper.getFaveMerchants(from, size)
            .map { response ->
                val merchants = response.hits.merchants
                ArrayList(merchants.map { it.merchant })
            }
            .doOnNext {
                mFaveMerchants.addAll(it)
            }
    }

    /**
     * search for list of fave merchants that contains the query
     * @return list of fave merchants
     */
    override fun getMerchants(query: String): Observable<ArrayList<Merchant>> {
        return apiHelper.searchForFaveMerchants(query)
            .map { response ->
                val merchants = response.hits.merchants
                ArrayList(merchants.map { it.merchant })
            }
    }
}
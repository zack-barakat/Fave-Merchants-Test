package com.android.favemerchants.data.repositories

import com.android.favemerchants.data.model.Merchant
import com.android.favemerchants.data.network.IApiHelper
import com.android.favemerchants.di.scopes.ApplicationScope
import io.reactivex.Observable
import javax.inject.Inject


interface IFaveMerchantRepository {
    fun getMerchants(): Observable<ArrayList<Merchant>>

    fun getMerchants(query: String): Observable<ArrayList<Merchant>>
}

@ApplicationScope
open class FaveMerchantRepository @Inject constructor(private val apiHelper: IApiHelper) : IFaveMerchantRepository {

    private var mFaveMerchants = arrayListOf<Merchant>()

    /**
     * get the list of fave merchants and persist them in memory
     * @return list of fave merchants
     */
    override fun getMerchants(): Observable<ArrayList<Merchant>> {
        return if (mFaveMerchants.isNotEmpty()) {
            Observable.just(mFaveMerchants)
        } else {
            apiHelper.faveMerchants
                .doOnNext {
                    mFaveMerchants = it
                }
        }
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
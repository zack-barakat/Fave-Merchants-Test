package com.android.favemerchants.data.repositories

import com.android.favemerchants.data.model.Merchant
import com.android.favemerchants.data.network.IApiHelper
import com.android.favemerchants.di.scopes.ApplicationScope
import io.reactivex.Observable
import javax.inject.Inject


@ApplicationScope
open class FakeFaveMerchantRepository @Inject constructor(private val apiHelper: IApiHelper) : IFaveMerchantRepository {

    private var mFaveMerchants = arrayListOf<Merchant>()

    init {
        mFaveMerchants.add(Merchant("Old Town", "Kuala Lumpur", "oldown@gmail.com"))
        mFaveMerchants.add(Merchant("Starbucks", "Kuala Lumpur", "starbucks@gmail.com"))
        mFaveMerchants.add(Merchant("KFC", "Kuala Lumpur", "kfc@gmail.com"))
        mFaveMerchants.add(Merchant("Nandos", "Kuala Lumpur", "nandos@gmail.com"))
        mFaveMerchants.add(Merchant("KGB", "Kuala Lumpur", "kgb@gmail.com"))
        mFaveMerchants.add(Merchant("Subway", "Kuala Lumpur", "subway@gmail.com"))
        mFaveMerchants.add(Merchant("Mcdonald", "Kuala Lumpur", "Mcdonald@gmail.com"))
        mFaveMerchants.add(Merchant("Carl's Junior", "Kuala Lumpur", "carlsjunior@gmail.com"))
    }

    /**
     * get the list of fave merchants and persist them in memory
     * @return list of fave merchants
     */
    override fun getMerchants(): Observable<ArrayList<Merchant>> {
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
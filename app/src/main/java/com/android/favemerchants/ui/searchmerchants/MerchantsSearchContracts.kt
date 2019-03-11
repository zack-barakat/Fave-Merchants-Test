package com.android.favemerchants.ui.searchmerchants

import com.android.favemerchants.data.model.Merchant
import com.android.favemerchants.ui.base.BasePresenter
import com.android.favemerchants.ui.base.BaseView

interface MerchantsSearchContracts {

    interface View : BaseView {
        fun showMerchantsSearchResult(merchants: ArrayList<Merchant>)

        fun showEmptyMerchantsResults()

        fun openEmailMerchantScreen(merchantName: String, email: String)

        fun openMerchantWebsite(website: String)
    }

    interface Presenter<V : View> : BasePresenter<V> {

        fun onQueryChange(query: String)

        fun onEmailMerchantClick(position: Int)

        fun onMerchantNameClick(position: Int)

    }
}

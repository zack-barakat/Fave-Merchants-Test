package com.android.favemerchants.ui.favemerchants

import com.android.favemerchants.data.model.Merchant
import com.android.favemerchants.ui.base.BasePresenter
import com.android.favemerchants.ui.base.BaseView

interface FaveMerchantsContracts {

    interface View : BaseView {
        fun showMerchants(merchants: ArrayList<Merchant>)

        fun openSearchScreen()

        fun openEmailMerchantScreen(merchantName: String, email: String)

    }

    interface Presenter<V : View> : BasePresenter<V> {
        fun onSearchClick()

        fun onEmailMerchantClick(position: Int)
    }
}

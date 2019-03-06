package com.android.favemerchants.ui.splash

import com.android.favemerchants.ui.base.BasePresenter
import com.android.favemerchants.ui.base.BaseView

interface SplashContracts {

    interface View : BaseView {
        fun showMainScreen()
    }

    interface Presenter<V : View> : BasePresenter<V>
}

package com.android.favemerchants.ui.favemerchants

import com.android.favemerchants.data.IDataManager
import com.android.favemerchants.data.model.Merchant
import com.android.favemerchants.ui.base.BaseMvpPresenter
import com.android.favemerchants.ui.base.ErrorView
import javax.inject.Inject

class FaveMerchantsPresenter @Inject
constructor(dataManager: IDataManager) : BaseMvpPresenter<FaveMerchantsContracts.View>(dataManager),
    FaveMerchantsContracts.Presenter<FaveMerchantsContracts.View> {

    private var mMerchants = arrayListOf<Merchant>()

    override fun onAttachView(view: FaveMerchantsContracts.View) {
        super.onAttachView(view)
        fetchAndShowFaveMerchants()
    }

    private fun fetchAndShowFaveMerchants() {
        view.showProgress()
        val disposable = mFaveMerchantRepository.getMerchants(0, 10)
            .subscribe({
                mMerchants = it
                view.hideProgress()
                view.showMerchants(mMerchants)
            }, {
                view.hideProgress()
                handleApiError(it, ErrorView.ERROR_TOAST)
            })
        addToSubscription(disposable)
    }

    override fun onSearchClick() {
        view.openSearchScreen()
    }

    override fun onEmailMerchantClick(position: Int) {
        if (mMerchants.size >= position) {
            val merchant = mMerchants[position]
            val name = merchant.name
            val email = merchant.email
            view.openEmailMerchantScreen(name, email)
        }
    }
}

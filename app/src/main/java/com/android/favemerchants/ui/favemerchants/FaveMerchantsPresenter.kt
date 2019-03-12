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

    private var from = 0

    override fun onAttachView(view: FaveMerchantsContracts.View) {
        super.onAttachView(view)
        fetchAndShowFaveMerchants()
    }

    private fun fetchAndShowFaveMerchants() {
        view.showProgress()
        val disposable = mFaveMerchantRepository.getMerchants(from + 1, 10)
            .subscribe({ merchants ->
                view.hideProgress()
                if (merchants.isNotEmpty()) {
                    if (mMerchants.size > 0) {
                        view.removeLoadingMore()
                    }
                    mMerchants.addAll(merchants)
                    view.showMerchants(mMerchants)
                    from = mMerchants.size
                }
            }, {
                view.hideProgress()
                handleApiError(it, ErrorView.ERROR_TOAST)
            })
        addToSubscription(disposable)
    }

    override fun loadMoreMerchants() {
        fetchAndShowFaveMerchants()
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

    override fun onMerchantNameClick(position: Int) {
        if (mMerchants.size >= position) {
            val merchant = mMerchants[position]
            if (merchant.website.isNotEmpty()) {
                view.openMerchantWebsite(merchant.website)
            }
        }
    }
}

package com.android.favemerchants.ui.searchmerchants

import com.android.favemerchants.data.IDataManager
import com.android.favemerchants.data.model.Merchant
import com.android.favemerchants.ui.base.BaseMvpPresenter
import com.android.favemerchants.ui.base.ErrorView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MerchantsSearchPresenter @Inject
constructor(dataManager: IDataManager) : BaseMvpPresenter<MerchantsSearchContracts.View>(dataManager),
    MerchantsSearchContracts.Presenter<MerchantsSearchContracts.View> {

    private var mMerchants = arrayListOf<Merchant>()
    private val searchQuerySubject = PublishSubject.create<String>()

    override fun onAttachView(view: MerchantsSearchContracts.View) {
        super.onAttachView(view)

        configureRxSearch()
    }

    override fun onQueryChange(query: String) {
        searchQuerySubject.onNext(query)
    }

    private fun configureRxSearch() {
        val disposable = searchQuerySubject
            .debounce(300, TimeUnit.MILLISECONDS, Schedulers.io())
            .filter { it.isNotEmpty() }
            .distinctUntilChanged()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                searchAndDisplayMerchants(it)
            }, {
                it.printStackTrace()
            })
        addToSubscription(disposable)
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

    private fun searchAndDisplayMerchants(query: String) {
        view.showProgress()
        val disposable = mFaveMerchantRepository.getMerchants(query)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mMerchants = it
                view.hideProgress()
                if (it.isEmpty()) {
                    view.showEmptyMerchantsResults()
                } else {
                    view.showMerchantsSearchResult(it)
                }
            }, {
                view.hideProgress()
                handleApiError(it, ErrorView.ERROR_DIALOG)
            })
        addToSubscription(disposable)
    }
}

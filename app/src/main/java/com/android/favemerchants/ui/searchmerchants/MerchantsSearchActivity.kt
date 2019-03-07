package com.android.favemerchants.ui.searchmerchants

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.android.favemerchants.R
import com.android.favemerchants.data.model.Merchant
import com.android.favemerchants.ui.base.BaseMvpActivity
import com.android.favemerchants.ui.base.BasePresenter
import com.android.favemerchants.ui.favemerchants.MerchantsAdapter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_merchant_search.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class MerchantsSearchActivity : BaseMvpActivity(), MerchantsSearchContracts.View, SearchView.OnQueryTextListener {

    @Inject
    lateinit var mPresenter: MerchantsSearchContracts.Presenter<MerchantsSearchContracts.View>

    private lateinit var mMerchantsSearchAdapter: MerchantsAdapter

    public override fun getPresenter(): BasePresenter<*> {
        return mPresenter
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent?.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_merchant_search)
        setupLayout()
        mPresenter.onAttachView(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val menuItem = menu.findItem(R.id.action_search)
        val searchView = menuItem.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        menuItem.expandActionView()
        menuItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                return false
            }

            override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                finish()
                return true
            }
        })
        return true
    }

    override fun sendExtrasToPresenter(extras: Bundle) {

    }

    private fun setupLayout() {
        val disposable = Observable.just("")
            .delay(
                resources.getInteger(R.integer.anim_search_reveal_duration) + 100L,
                TimeUnit.MILLISECONDS,
                Schedulers.io()
            )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ animateShowContent() }, {})
        addToSubscription(disposable)
        setupSearchResultRecyclerView()
    }

    private fun animateShowContent() {
        cvSearchContentContainer.alpha = 0f
        cvSearchContentContainer.visibility = View.VISIBLE
        cvSearchContentContainer.animate()
            .alpha(1f)
            .setDuration(resources.getInteger(android.R.integer.config_shortAnimTime).toLong())
            .setListener(null)
            .start()
    }

    private fun setupSearchResultRecyclerView() {
        mMerchantsSearchAdapter = MerchantsAdapter { mPresenter.onEmailMerchantClick(it) }
        rvSearchMerchants.adapter = mMerchantsSearchAdapter

        val gridManager = LinearLayoutManager(this)
        rvSearchMerchants.layoutManager = gridManager
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String): Boolean {
        mPresenter.onQueryChange(newText)
        return true
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun showMerchantsSearchResult(merchants: ArrayList<Merchant>) {
        tvNoResult.visibility = View.GONE
        rvSearchMerchants.visibility = View.VISIBLE
        mMerchantsSearchAdapter.refreshMerchants(merchants)
    }

    override fun showEmptyMerchantsResults() {
        tvNoResult.visibility = View.VISIBLE
        rvSearchMerchants.visibility = View.GONE
    }

    override fun openEmailMerchantScreen(merchantName: String, email: String) {

    }
}

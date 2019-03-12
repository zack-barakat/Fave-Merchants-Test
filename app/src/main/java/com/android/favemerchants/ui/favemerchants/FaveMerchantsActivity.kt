package com.android.favemerchants.ui.favemerchants

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import com.android.favemerchants.R
import com.android.favemerchants.data.model.Merchant
import com.android.favemerchants.ui.base.BaseMvpActivity
import com.android.favemerchants.ui.base.BasePresenter
import com.android.favemerchants.ui.searchmerchants.MerchantsSearchActivity
import kotlinx.android.synthetic.main.activity_fave_merchants.*
import org.jetbrains.anko.startActivity
import javax.inject.Inject


class FaveMerchantsActivity : BaseMvpActivity(), FaveMerchantsContracts.View {

    @Inject
    lateinit var mPresenter: FaveMerchantsContracts.Presenter<FaveMerchantsContracts.View>

    private lateinit var mAdapter: MerchantsPaginatedAdapter

    public override fun onCreate(savedInstanceState: Bundle?) {
        activityComponent?.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fave_merchants)
        setupLayout()
        mPresenter.onAttachView(this)
    }

    override fun sendExtrasToPresenter(extras: Bundle) {

    }

    private fun setupLayout() {
        supportActionBar?.title = getString(R.string.title_merchants)
        setupMerchantsRecyclerView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val menuItem = menu.findItem(R.id.action_open_search)
        menuItem?.setOnMenuItemClickListener {
            mPresenter.onSearchClick()
            true
        }
        return true
    }

    private fun setupMerchantsRecyclerView() {
        mAdapter = MerchantsPaginatedAdapter({ position ->
            mPresenter.onEmailMerchantClick(position)
        }, { position ->
            mPresenter.onMerchantNameClick(position)
        })
        rvMerchants.adapter = mAdapter
        val linearLayoutManager = LinearLayoutManager(this)
        rvMerchants.layoutManager = linearLayoutManager

        rvMerchants.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val visibleItemCount = linearLayoutManager.childCount
                val totalItemCount = linearLayoutManager.itemCount
                val pastVisibleItems = linearLayoutManager.findFirstVisibleItemPosition()

                if (visibleItemCount + pastVisibleItems >= totalItemCount && !isLoading) {
                    val merchant = Merchant("", "", "", "", "")
                    merchant.type = "LOADING"
                    mAdapter.addLoadingItem(merchant)
                    mPresenter.loadMoreMerchants()
                    isLoading = true
                }
            }
        })
    }

    public override fun getPresenter(): BasePresenter<*> {
        return mPresenter
    }

    private var isLoading: Boolean = false

    override fun showMerchants(merchants: ArrayList<Merchant>) {
        if (merchants.size > 0) {
            mAdapter.addItems(merchants)
            isLoading = false
        }
    }

    override fun removeLoadingMore() {
        mAdapter.removeLoadingItem()
    }

    override fun openSearchScreen() {
        startActivity<MerchantsSearchActivity>()
        overridePendingTransition(R.anim.enter_search_activiaty_animation, android.R.anim.fade_out)
    }

    override fun openEmailMerchantScreen(merchantName: String, email: String) {
        val intent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", email, null))
        intent.putExtra(Intent.EXTRA_EMAIL, email)
        val emailTitle =
            String.format(getString(com.android.favemerchants.R.string.email_merchant_title), merchantName)
        startActivity(Intent.createChooser(intent, emailTitle))
    }

    override fun openMerchantWebsite(website: String) {
        try {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(website))
            startActivity(browserIntent)
        } catch (e: ActivityNotFoundException) {
            e.printStackTrace()
        }
    }
}

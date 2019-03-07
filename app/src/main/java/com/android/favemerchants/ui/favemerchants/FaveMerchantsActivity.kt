package com.android.favemerchants.ui.favemerchants

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
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

    private lateinit var mAdapter: MerchantsAdapter

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
        mAdapter = MerchantsAdapter { position ->
            mPresenter.onEmailMerchantClick(position)
        }
        rvMerchants.adapter = mAdapter
        val gridLayoutManager = LinearLayoutManager(this)
        rvMerchants.layoutManager = gridLayoutManager
    }

    public override fun getPresenter(): BasePresenter<*> {
        return mPresenter
    }

    override fun showMerchants(merchants: ArrayList<Merchant>) {
        mAdapter.refreshMerchants(merchants)
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
}

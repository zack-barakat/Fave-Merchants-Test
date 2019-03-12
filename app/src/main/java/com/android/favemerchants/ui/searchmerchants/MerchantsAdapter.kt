package com.android.favemerchants.ui.searchmerchants

import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.favemerchants.R
import com.android.favemerchants.data.model.Merchant
import kotlinx.android.synthetic.main.item_merchant.view.*


class MerchantsAdapter(
    val onMerchantEmailClick: (position: Int) -> Unit,
    val onMerchantWebClick: (position: Int) -> Unit
) :
    RecyclerView.Adapter<MerchantsAdapter.MerchantHolder>() {

    private var mMerchants = arrayListOf<Merchant>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MerchantHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_merchant, parent, false)
        return MerchantHolder(view)
    }

    override fun getItemCount() = mMerchants.size

    override fun onBindViewHolder(holder: MerchantHolder, position: Int) {
        holder.bind(mMerchants[position])
    }

    fun refreshMerchants(merchants: ArrayList<Merchant>) {
        mMerchants = merchants
        notifyDataSetChanged()
    }

    inner class MerchantHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(merchant: Merchant) {
            with(itemView) {
                if (merchant.website.isNotEmpty()) {
                    tvMerchantWebsite.visibility = View.VISIBLE
                    tvMerchantWebsite.paintFlags = tvMerchantWebsite.paintFlags or Paint.UNDERLINE_TEXT_FLAG
                    tvMerchantWebsite.setOnClickListener { onMerchantWebClick.invoke(adapterPosition) }
                } else {
                    tvMerchantWebsite.visibility = View.GONE
                }
                tvMerchantName.text = merchant.name
                tvMerchantLocation.text = merchant.country
                if (merchant.email.isEmpty()) {
                    tvMerchantEmail.visibility = View.GONE
                } else {
                    tvMerchantEmail.visibility = View.VISIBLE
                    tvMerchantEmail.text = merchant.email
                }
                tvMerchantEmail.setOnClickListener { onMerchantEmailClick.invoke(adapterPosition) }
            }
        }
    }
}
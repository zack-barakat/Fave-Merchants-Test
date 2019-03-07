package com.android.favemerchants.ui.favemerchants

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.favemerchants.R
import com.android.favemerchants.data.model.Merchant
import kotlinx.android.synthetic.main.item_merchant.view.*


class MerchantsAdapter(val onEmailMerchantClick: (position: Int) -> Unit) :
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
                tvMerchantName.text = merchant.name
                tvMerchantLocation.text = merchant.location
                tvMerchantEmail.text = merchant.email
                tvMerchantEmail.setOnClickListener { onEmailMerchantClick.invoke(adapterPosition) }
            }
        }
    }
}
package com.android.favemerchants.ui.favemerchants

import android.graphics.Paint
import android.support.annotation.Nullable
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.favemerchants.R
import com.android.favemerchants.data.model.Merchant
import kotlinx.android.synthetic.main.item_merchant.view.*


class MerchantsPaginatedAdapter(
    val onMerchantEmailClick: (position: Int) -> Unit,
    val onMerchantWebClick: (position: Int) -> Unit
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mMerchants = arrayListOf<Merchant>()

    private val TYPE_LOADING = 1
    private val TYPE_MERCHANT = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_LOADING) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_footer, parent, false)
            LoadingViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_merchant, parent, false)
            MerchantHolder(view)
        }
    }

    override fun getItemCount() = mMerchants.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == TYPE_MERCHANT) {
            (holder as MerchantHolder).bind(mMerchants[position])
        } else {
            (holder as LoadingViewHolder).bind()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (mMerchants[position].type == "LOADING") {
            TYPE_LOADING
        } else {
            TYPE_MERCHANT
        }
    }

    fun addItems(merchants: ArrayList<Merchant>) {
        val positionStart = merchants.size + 1
        this.mMerchants.addAll(merchants)

        notifyItemRangeInserted(positionStart, merchants.size)
    }

    fun addLoadingItem(merchant: Merchant) {
        mMerchants.add(merchant)
        notifyItemInserted(mMerchants.size - 1)
    }

    fun removeLoadingItem() {
        mMerchants.removeAt(mMerchants.size - 1)
        notifyItemRemoved(mMerchants.size - 1)
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


    inner class LoadingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind() {}
    }

    private inner class MyDiffCallback(
        private val newMerchants: ArrayList<Merchant>,
        private val oldMerchants: ArrayList<Merchant>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int {
            return oldMerchants.size
        }

        override fun getNewListSize(): Int {
            return newMerchants.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldMerchants[oldItemPosition].name == newMerchants[newItemPosition].name
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldMerchants[oldItemPosition].name == newMerchants[newItemPosition].name
        }

        @Nullable
        override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
            return super.getChangePayload(oldItemPosition, newItemPosition)
        }
    }


}
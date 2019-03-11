package com.android.favemerchants.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MerchantsResponse(
    @SerializedName("_shards")
    val shards: Shards?,
    @SerializedName("hits")
    val hits: Hits,
    @SerializedName("timed_out")
    val timedOut: Boolean?,
    @SerializedName("took")
    val took: Double?
) : Parcelable

@Parcelize
data class Shards(
    @SerializedName("failed")
    val failed: Int?,
    @SerializedName("skipped")
    val skipped: Int?,
    @SerializedName("successful")
    val successful: Int?,
    @SerializedName("total")
    val total: Int?
) : Parcelable

@Parcelize
data class Hits(
    @SerializedName("hits")
    val merchants: ArrayList<MerchantHit>,
    @SerializedName("max_score")
    val maxScore: Double,
    @SerializedName("total")
    val total: Int
) : Parcelable

@Parcelize
data class MerchantHit(
    @SerializedName("_id")
    val id: String,
    @SerializedName("_index")
    val index: String,
    @SerializedName("_score")
    val score: Double,
    @SerializedName("_source")
    val merchant: Merchant,
    @SerializedName("_type")
    val type: String
) : Parcelable

@Parcelize
data class Merchant(
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("website")
    val website: String
) : Parcelable

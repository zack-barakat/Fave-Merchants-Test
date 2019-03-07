package com.android.favemerchants.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Merchant(var name: String, var location: String, var email: String) : Parcelable

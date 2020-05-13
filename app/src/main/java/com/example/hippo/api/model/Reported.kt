package com.example.hippo.api.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Reported(
    val status: Int,
    val error_message: String,
    val banned: List<Int>
) : Parcelable
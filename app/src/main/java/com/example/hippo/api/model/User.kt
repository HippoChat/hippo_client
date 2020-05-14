package com.example.hippo.api.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val status: Int,
    val error_message: String,
    val user: UserInfo
) : Parcelable

@Parcelize
data class UserInfo(
    val id: Int,
    val name: String,
    val age_group: String,
    val language: String,
    val image: String
) : Parcelable

@Parcelize
data class PartnerInfo(
    val status: Int,
    val error_message: String,
    val partner_id: Int
) : Parcelable
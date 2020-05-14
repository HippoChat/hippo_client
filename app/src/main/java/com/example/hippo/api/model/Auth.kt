package com.example.hippo.api.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Status(
    val status: Int,
    val error_message: String
) : Parcelable

@Parcelize
data class SignUp
    (
    val status: Int,
    val error_message: String?,
    val me: GeneralInfo?
) : Parcelable

@Parcelize
data class GeneralInfo(
    val public: PublicInfo,
    val private: PrivateInfo
) : Parcelable

@Parcelize
data class PublicInfo(
    val id: Int,
    val name: String,
    val age_group: String,
    val language: String,
    val image: String
) : Parcelable

@Parcelize
data class PrivateInfo(
    val phone: String,
    val token: String
) : Parcelable
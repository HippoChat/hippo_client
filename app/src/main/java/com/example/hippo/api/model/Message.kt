package com.example.hippo.api.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Message(
    val status: Int,
    val error_message: String?,
    val message_id: Int?
) : Parcelable

@Parcelize
data class Messages(
    val status: Int,
    val error_message: String?,
    val messages: MessageData
) : Parcelable

@Parcelize
data class MessageData(
    val id: Int,
    val timestamp: String,
    val incoming: Boolean?,
    val sender: Int,
    val receiver: Int,
    val message: String,
    val image: String?,
    val reply_to_message_id: Int?
) : Parcelable
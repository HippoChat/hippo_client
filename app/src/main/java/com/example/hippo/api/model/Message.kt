package com.example.hippo.api.model

data class Message(
    val status: Int,
    val error_message: String,
    val message_id: Int
)
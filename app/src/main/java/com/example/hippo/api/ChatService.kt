package com.example.hippo.api

import com.example.hippo.api.model.Message
import com.example.hippo.api.model.Messages
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ChatService {
    @POST("/chat/send_message")
    fun sendMessage(
        @Body receiver_id: Int,
        @Body message: String,
        @Body image: String,
        @Body reply_to_message_id: Int
    ): Call<Message>

    @POST("/chat/messages")
    fun getMessages(): Observable<Messages>
}
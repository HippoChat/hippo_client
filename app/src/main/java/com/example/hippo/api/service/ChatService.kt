package com.example.hippo.api.service

import com.example.hippo.api.model.Message
import com.example.hippo.api.model.Messages
import com.example.hippo.api.model.SendMessage
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ChatService {
    @POST("chat/send_message")
    fun sendMessage(
        @Body message: SendMessage
    ): Call<Message>

    @POST("chat/messages")
    fun getMessages(): Observable<Messages>
}
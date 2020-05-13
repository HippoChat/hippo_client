package com.example.hippo.api

import com.example.hippo.api.model.SignUp
import com.example.hippo.api.model.Status
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("/auth/send_verification_code")
    fun sendVerificationCode(@Body phone: String)

    @POST("/auth/verify_security_code")
    fun verifyCode(@Body phone: String, @Body code: String): Call<Status>

    @POST("/auth/sign_up")
    fun signUp(@Body phone: String,
        @Body code: String,
        @Body name: String,
        @Body age_group: String,
        @Body language: String
    ) : Call<SignUp>

    @POST("/auth/logout")
    fun logout(@Body id: Int) : Call<Status>
}
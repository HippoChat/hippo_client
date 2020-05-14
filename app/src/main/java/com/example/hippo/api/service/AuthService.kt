package com.example.hippo.api.service

import com.example.hippo.api.model.SignUp
import com.example.hippo.api.model.Status
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("/auth/send_verification_code")
    fun sendVerificationCode(@Body phone: String)

    @POST("/auth/verify_security_code")
    fun verifyCode(@Body phone: String, @Body code: String): Single<Status>

    @POST("/auth/sign_up")
    fun signUp(@Body phone: String,
        @Body code: String,
        @Body name: String,
        @Body age_group: String,
        @Body language: String
    ) : Single<SignUp>

    @POST("/auth/logout")
    fun logout(@Body id: Int) : Single<Status>
}
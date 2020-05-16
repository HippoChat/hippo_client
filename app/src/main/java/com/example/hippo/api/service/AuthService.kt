package com.example.hippo.api.service

import com.example.hippo.api.model.*
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("auth/send_verification_code")
    fun sendVerificationCode(@Body phone: PhoneNumber) : Completable

    @POST("auth/verify_phone_code")
    fun verifyCode(@Body phoneCode: PhoneCode): Single<Status>

    @POST("auth/sign_up")
    fun signUp(@Body signUpData: SignUpData) : Single<SignUp>

    @POST("auth/logout")
    fun logout() : Single<Status>
}
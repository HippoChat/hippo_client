package com.example.hippo.api.service

import com.example.hippo.api.model.*
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserService {
    @POST("user/set_info")
    fun setInfo(
        @Body userInfo: UserInfo
    ): Single<SignUp>

    @GET("user/{id}")
    fun getInfo(@Path("id") id: Int): Single<User>

    @POST("user/wait_for_partner")
    fun waitForPartner(): Observable<PartnerInfo>
}
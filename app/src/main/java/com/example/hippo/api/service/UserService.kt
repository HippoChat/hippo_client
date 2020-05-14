package com.example.hippo.api.service

import com.example.hippo.api.model.PartnerInfo
import com.example.hippo.api.model.SignUp
import com.example.hippo.api.model.UserInfo
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserService {
    @POST("/user/set_image")
    fun setImage(@Body image: String) : Call<SignUp>

    @GET("/user/{id}")
    fun getInfo(@Path("id") id: Int) : Call<UserInfo>

    @POST("/user/wait_for_partner")
    fun waitForPartner() : Observable<PartnerInfo>
}
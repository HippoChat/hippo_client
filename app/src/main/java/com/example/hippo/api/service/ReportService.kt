package com.example.hippo.api.service

import com.example.hippo.api.model.Reported
import com.example.hippo.api.model.Status
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ReportService {
    @POST("/ic_report_user/report")
    fun reportUser(@Body report_reason: Int, @Body reported_id: Int): Call<Status>

    @GET("/ic_report_user/blocked")
    fun getReported(): Call<Reported>
}
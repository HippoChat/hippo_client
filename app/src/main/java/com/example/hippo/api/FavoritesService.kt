package com.example.hippo.api

import com.example.hippo.api.model.Favorites
import com.example.hippo.api.model.Status
import retrofit2.Call
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FavoritesService {
    @GET("/bookmark")
    fun getFavorites() : Call<Favorites>

    @POST("/bookmark/{id}")
    fun addFavorite(@Path ("id") id: Int): Call<Status>

    @DELETE("/bookmark/{id}")
    fun removeFavorite(@Path ("id") id: Int): Call<Status>
}
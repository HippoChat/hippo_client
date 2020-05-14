package com.example.hippo.api

import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import okhttp3.Authenticator

class TokenAuthenticator : Authenticator {

    override fun authenticate(route: Route?, response: Response) : Request? {
        val token = getNewToken()
        return response.request.newBuilder()
            .header("Authorization", token).build()
    }

    private fun getNewToken(): String {
        // TODO: Add token request
        return ""
    }
}
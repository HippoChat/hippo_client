package com.example.hippo.ui.registration

import android.content.Context
import com.example.hippo.api.RestClient
import com.example.hippo.api.model.SignUp
import com.example.hippo.api.model.User
import com.example.hippo.ui.SecurePrefs
import io.reactivex.Completable
import io.reactivex.Single

class RegistrationUtils(val context: Context) {
    fun signUp(): Single<SignUp> {
        val name = SecurePrefs.getName()
        SecurePrefs.getNumber()
        SecurePrefs.getCode()
        RestClient.instance.authService.signUp(

        )
    }
}
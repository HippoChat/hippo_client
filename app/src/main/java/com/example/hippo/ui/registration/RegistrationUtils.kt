package com.example.hippo.ui.registration

import android.content.Context
import com.example.hippo.api.RestClient
import com.example.hippo.api.model.SignUp
import com.example.hippo.ui.SecurePrefs
import io.reactivex.Single

class RegistrationUtils(val context: Context) {
    fun signUp(): Single<SignUp> {
        val name = SecurePrefs.getName()
        val phone = SecurePrefs.getNumber()
        val code = SecurePrefs.getCode()
        val age_group = SecurePrefs.getAge()
        val language = SecurePrefs.getLanguage()
        return RestClient.instance.authService.signUp(
            phone, code, name, age_group, language
        )
    }
}

package com.example.hippo.ui.registration

import android.content.Context
import com.example.hippo.R
import com.example.hippo.api.RestClient
import com.example.hippo.api.model.SignUp
import com.example.hippo.api.model.SignUpData
import com.example.hippo.ui.SecurePrefs
import io.reactivex.Single

class RegistrationUtils(val context: Context) {
    fun signUp(): Single<SignUp> {
        val name = SecurePrefs.getName()
        val phone = SecurePrefs.getNumber()
        val code = SecurePrefs.getCode()

        val languageCodes = context.resources.getStringArray(R.array.languages_api)
        val languageCode = languageCodes[SecurePrefs.getLanguage()]
        val ageRanges = context.resources.getStringArray(R.array.age_ranges_api)
        val ageRange = ageRanges[SecurePrefs.getAge()]

        return RestClient.instance.authService.signUp(
            SignUpData(phone, code, name, ageRange, languageCode)
        )
    }
}

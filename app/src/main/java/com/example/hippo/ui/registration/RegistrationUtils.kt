package com.example.hippo.ui.registration

import android.content.Context
import com.example.hippo.R
import com.example.hippo.api.RestClient
import com.example.hippo.api.model.SignUp
import com.example.hippo.api.model.SignUpData
import com.example.hippo.ui.SecurePrefs
import io.reactivex.Single

class RegistrationUtils(val context: Context) {
    private val ageRanges = context.resources.getStringArray(R.array.age_ranges_api)
    private val languageCodes = context.resources.getStringArray(R.array.languages_api)

    fun signUp(): Single<SignUp> {
        val name = SecurePrefs.getName()
        val phone = SecurePrefs.getNumber()
        val code = SecurePrefs.getCode()

        return RestClient.instance.authService.signUp(
            SignUpData(
                phone,
                code,
                name,
                getAgeRange(SecurePrefs.getAge()),
                getLanguageCode(SecurePrefs.getLanguage())
            )
        )
    }

    fun getLanguageCode(languageSelection: Int): String {
        val languageCode = languageCodes[languageSelection]
        return languageCode
    }

    fun getAgeRange(ageSelection: Int): String {
        val ageRange = ageRanges[ageSelection]
        return ageRange
    }

    fun languageToSelection(code: String): Int {
        return languageCodes.indexOf(code)
    }

    fun ageToSelection(age: String): Int {
        return ageRanges.indexOf(age)
    }
}

package com.example.hippo.ui

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

object SecurePrefs {
    private val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
    private val masterKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)

    private lateinit var sharedPreferences: SharedPreferences

    fun createEncryptedPreferences(context: Context) {
        sharedPreferences = EncryptedSharedPreferences
            .create(
                "secure_data.txt",
                masterKeyAlias,
                context,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
    }

    fun putId(myId: Int) {
        sharedPreferences.edit().putInt(idKey, myId).apply()
    }

    fun getId() = sharedPreferences.getInt(idKey, -1)

    fun putToken(myToken: String) {
        sharedPreferences.edit().putString(tokenKey, myToken).apply()
    }

    fun getToken() = sharedPreferences.getString(tokenKey, "NONE")

    fun putNumber(number: String) {
        sharedPreferences.edit().putString(numberKey, number).apply()
    }

    fun getNumber() = sharedPreferences.getString(numberKey, "").toString()

    fun putCode(verificationCode: String) {
        sharedPreferences.edit().putString(verificationCodeKey, verificationCode).apply()
    }

    fun getCode() = sharedPreferences.getString(verificationCodeKey, "").toString()

    fun putName(name: String) {
        sharedPreferences.edit().putString(nameKey, name).apply()
    }

    fun getName() = sharedPreferences.getString(nameKey, "").toString()


    fun putAge(age: Int) {
        sharedPreferences.edit().putInt(ageKey, age).apply()
    }

    fun getAge() = sharedPreferences.getInt(ageKey, 0)

    fun putLanguage(language: Int) {
        sharedPreferences.edit().putInt(languageKey, 0).apply()
    }

    fun getLanguage() = sharedPreferences.getInt(languageKey, 0)

    private const val tokenKey = "token"
    private const val idKey = "id"
    private const val numberKey = "number"
    private const val verificationCodeKey = "verificationCode"
    private const val nameKey = "name"
    private const val ageKey = "age"
    private const val languageKey = "language"

}

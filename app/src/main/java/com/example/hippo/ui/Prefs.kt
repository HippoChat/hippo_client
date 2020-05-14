package com.example.hippo.ui

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

object SecurePrefs {
    private val keyGenParameterSpec = MasterKeys.AES256_GCM_SPEC
    private val masterKeyAlias = MasterKeys.getOrCreate(keyGenParameterSpec)

    private lateinit var sharedPreferences: SharedPreferences

    fun createEncryptedPreferences(context: Context){
        sharedPreferences = EncryptedSharedPreferences
            .create(
                "secure_data.txt",
                masterKeyAlias,
                context,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            )
    }

    fun putNumber(number: String){
        sharedPreferences.edit().putString(numberKey, number).apply()
    }

    fun getNumber() = sharedPreferences.getString(numberKey, "").toString()


    fun putName(name: String){
        sharedPreferences.edit().putString(nameKey, name).apply()
    }

    fun getName() = sharedPreferences.getString(nameKey, "").toString()


    fun putAge(age: String){
        sharedPreferences.edit().putString(ageKey, age).apply()
    }

    fun getAge() = sharedPreferences.getString(ageKey, "").toString()

    fun putLanguage(language: String){
        sharedPreferences.edit().putString(languageKey, language).apply()
    }

    fun getLanguage() = sharedPreferences.getString(languageKey, "").toString()

    private const val numberKey = "number"
    private const val nameKey = "name"
    private const val ageKey = "age"
    private const val languageKey = "language"

}

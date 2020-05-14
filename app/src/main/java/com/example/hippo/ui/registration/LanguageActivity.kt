package com.example.hippo.ui.registration

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.hippo.MainActivity
import com.example.hippo.R
import com.example.hippo.ui.SecurePrefs
import kotlinx.android.synthetic.main.activity_language_registration.*

class LanguageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language_registration)
//        registrationLanguageButton.setOnClickListener {
//            SecurePrefs.putLanguage(spLanguageSettings.selectedItemId.toString())
//            RegistrationUtils(this).signUp().map {
//                Log.d("AUTH", "signed up: $it")
//            }
//        }
        startActivity(Intent(this, MainActivity::class.java))
    }
}
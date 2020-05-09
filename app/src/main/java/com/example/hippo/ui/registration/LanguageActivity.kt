package com.example.hippo.ui.registration

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hippo.MainActivity
import com.example.hippo.R
import kotlinx.android.synthetic.main.activity_language_registration.*

class LanguageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language_registration)
        registrationLanguageButton.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
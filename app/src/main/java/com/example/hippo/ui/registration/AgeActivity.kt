package com.example.hippo.ui.registration

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hippo.R
import kotlinx.android.synthetic.main.activity_age_registration.*

class AgeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age_registration)
        registrationAgeButton.setOnClickListener {
            startActivity(Intent(this, LanguageActivity::class.java))
        }
    }
}
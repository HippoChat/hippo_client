package com.example.hippo.ui.registration

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hippo.R
import kotlinx.android.synthetic.main.activity_name_registration.*

class PersonalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name_registration)
        registrationNameButton.setOnClickListener {
            startActivity(Intent(this, AgeActivity::class.java))
        }
    }
}
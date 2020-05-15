package com.example.hippo.ui.registration

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hippo.R
import com.example.hippo.isValidName
import com.example.hippo.ui.SecurePrefs
import com.example.hippo.validate
import kotlinx.android.synthetic.main.activity_name_registration.*

class PersonalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name_registration)
        registrationNameButton.setOnClickListener {
            tv_name_settings.validate("Wrong name") { s -> s.isValidName() }

            tv_name_settings.text.toString().run {
                if(isValidName())
                {
                    SecurePrefs.putName(this)
                    startActivity(Intent(baseContext, AgeActivity::class.java))
                }
            }
        }
    }
}
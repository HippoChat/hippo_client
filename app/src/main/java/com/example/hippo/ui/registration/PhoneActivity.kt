package com.example.hippo.ui.registration

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.hippo.R
import com.example.hippo.isValidPhone
import com.example.hippo.ui.SecurePrefs
import com.example.hippo.validate
import kotlinx.android.synthetic.main.activity_phone_registration.*

// A splash screen - shows itself for 2 seconds, then passes the execution to a different Activity
class PhoneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_registration)
        registrationPhoneButton.setOnClickListener {
            registrationPhone.validate("Valid phone number required") { s -> s.isValidPhone() }
            registrationPhone.text.toString().run {
                if(isValidPhone())
                {
                    SecurePrefs.putNumber(this)
                    startActivity(Intent(baseContext, CodeActivity::class.java))
                }
            }
        }
    }
}
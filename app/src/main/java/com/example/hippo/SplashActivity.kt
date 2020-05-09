package com.example.hippo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.hippo.ui.registration.PhoneActivity

// A splash screen - shows itself for 2 seconds, then passes the execution to a different Activity
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            startActivity(Intent(this, PhoneActivity::class.java))
        }, 2000)
    }
}
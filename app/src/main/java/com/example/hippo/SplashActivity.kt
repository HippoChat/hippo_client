package com.example.hippo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.hippo.api.RestClient
import com.example.hippo.api.model.PhoneNumber
import com.example.hippo.ui.SecurePrefs
import com.example.hippo.ui.registration.PhoneActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject

// A splash screen - shows itself for 2 seconds, then passes the execution to a different Activity
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val start: Intent = if (SecurePrefs.getToken()!!.isNotEmpty()) {
                Intent(this, MainActivity::class.java)
            } else {
                Intent(this, PhoneActivity::class.java)
            }
            start.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            start.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(start)
        }, 2000)
    }
}
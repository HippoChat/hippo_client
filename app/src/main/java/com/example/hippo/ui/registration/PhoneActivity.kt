package com.example.hippo.ui.registration

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.hippo.R
import com.example.hippo.api.RestClient
import com.example.hippo.api.model.PhoneNumber
import com.example.hippo.isValidPhone
import com.example.hippo.ui.SecurePrefs
import com.example.hippo.validate
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_phone_registration.*

// A splash screen - shows itself for 2 seconds, then passes the execution to a different Activity
class PhoneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_registration)
        bt_registration_phone.setOnClickListener {
            et_phone.validate("Valid phone number required") { s -> s.isValidPhone() }
            et_phone.text.toString().run {
                if (isValidPhone()) {
                    SecurePrefs.putNumber("+$this")
                    // TODO: ERROR CHECKING
                    RestClient.instance.authService.sendVerificationCode(PhoneNumber(SecurePrefs.getNumber()))
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({}, { error -> Log.e("HIPPO", error.message) })
                    startActivity(Intent(baseContext, CodeActivity::class.java))
                }
            }
        }
    }
}
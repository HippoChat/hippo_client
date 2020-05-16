package com.example.hippo.ui.registration

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.hippo.R
import com.example.hippo.api.RestClient
import com.example.hippo.api.model.PhoneCode
import com.example.hippo.isValidCode
import com.example.hippo.ui.SecurePrefs
import com.example.hippo.util.subscribeIoObserveMain
import com.example.hippo.validate
import kotlinx.android.synthetic.main.activity_code_registration.*

class CodeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_registration)
        bt_verification.setOnClickListener {
            et_verification_code.validate("Wrong code") { s -> s.isValidCode() }
            et_verification_code.text.toString().run {
                // TODO: ERROR CHECKING
                RestClient.instance.authService.verifyCode(PhoneCode(SecurePrefs.getNumber(), this))
                    .subscribeIoObserveMain()
                    .subscribe({}, { error -> Log.e("HIPPO", error.message) })
                SecurePrefs.putCode(this)
                val newStart = Intent(baseContext, PersonalActivity::class.java)
                newStart.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                newStart.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(newStart)
            }
        }
    }
}
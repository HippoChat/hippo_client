package com.example.hippo.ui.registration

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.hippo.MainActivity
import com.example.hippo.R
import com.example.hippo.api.RestClient
import com.example.hippo.api.model.SignUp
import com.example.hippo.api.model.SignUpData
import com.example.hippo.ui.SecurePrefs
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_language_registration.*
import java.util.*

class LanguageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language_registration)
        bt_registration_lang.setOnClickListener {
            SecurePrefs.putLanguage(sp_language_settings.selectedItemId.toInt())
            // TODO: ERROR CHECKING
            RegistrationUtils(this).signUp()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result: SignUp ->
                    SecurePrefs.putId(result.me!!.public.id)
                    SecurePrefs.putToken(result.me.private.token)
                }, { error -> Log.e("HIPPO", error.message) })
            val newStart = Intent(this, MainActivity::class.java)
            newStart.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            newStart.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(newStart)
        }
    }
}
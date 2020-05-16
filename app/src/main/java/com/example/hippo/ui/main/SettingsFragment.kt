package com.example.hippo.ui.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.hippo.R
import com.example.hippo.api.RestClient
import com.example.hippo.api.model.User
import com.example.hippo.api.model.UserInfo
import com.example.hippo.ui.SecurePrefs
import com.example.hippo.ui.registration.RegistrationUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.settings_fragment.*

class SettingsFragment : Fragment() {
    private lateinit var btSave: Button
    private lateinit var btLogOut: Button
    private lateinit var etName: EditText
    private lateinit var spAge: Spinner
    private lateinit var spLanguage: Spinner
    private lateinit var ibtAvatar: AvatarLoadingFragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        ibtAvatar =
            childFragmentManager.findFragmentByTag("avatar_loading") as AvatarLoadingFragment
        initData(context!!)
    }

    private fun initData(context: Context) {
        val regUtils = RegistrationUtils(context)
        RestClient.instance.userService.getInfo(SecurePrefs.getId())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ result: User ->
                et_name_settings.setText(result.user.name)
                sp_age_settings.setSelection(regUtils.ageToSelection(result.user.age_group))
                sp_language_settings.setSelection(regUtils.languageToSelection(result.user.language))
                if (result.user.image.isNotEmpty())
                    ibtAvatar.setImage(result.user.image)
            }, { error -> Log.e("HIPPO", error.message) })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.settings_fragment, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btSave = view.findViewById(R.id.bt_save_settings)
        btLogOut = view.findViewById(R.id.bt_sign_out)
        etName = view.findViewById(R.id.et_name_settings)
        spAge = view.findViewById(R.id.sp_age_settings)
        spLanguage = view.findViewById(R.id.sp_language_settings)

        btSave.setOnClickListener {
            RestClient.instance.userService.setInfo(
                UserInfo(
                    SecurePrefs.getId(),
                    et_name_settings.text.toString(),
                    RegistrationUtils(context!!).getAgeRange(spAge.selectedItemId.toInt()),
                    RegistrationUtils(context!!).getLanguageCode(spLanguage.selectedItemId.toInt()),
                    ibtAvatar.getImageString()
                )
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val t = Toast.makeText(activity, "Your info was updated :)", Toast.LENGTH_LONG)
                    t.show()
                }, { error -> Log.e("HIPPO", error.message) })
        }
    }
}
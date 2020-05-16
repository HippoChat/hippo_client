package com.example.hippo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.hippo.R
import com.example.hippo.ui.SecurePrefs
import kotlinx.android.synthetic.main.settings_fragment.*

class SettingsFragment : Fragment(){
    private lateinit var btSave: Button
    private lateinit var btLogOut: Button
    private lateinit var etName: EditText
    private lateinit var spAge: Spinner
    private lateinit var spLanguage: Spinner

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData()
    }

    private fun initData(){
        et_name_settings.setText(SecurePrefs.getName())
        sp_age_settings.setSelection(SecurePrefs.getAge().toInt())
        sp_language_settings.setSelection(SecurePrefs.getLanguage().toInt())
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


        btSave.setOnClickListener{
//            TODO: send data to server
            val t = Toast.makeText(activity, "Your info was updated :)", Toast.LENGTH_LONG)
            t.show()
        }
    }
}
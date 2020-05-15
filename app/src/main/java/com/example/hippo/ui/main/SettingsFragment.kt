package com.example.hippo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hippo.R
import com.example.hippo.ui.SecurePrefs
import kotlinx.android.synthetic.main.settings_fragment.*

class SettingsFragment : Fragment(){

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initData()
    }

    private fun initData(){
        tv_name_settings.setText(SecurePrefs.getName())
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
}
  package com.example.hippo

import android.app.Application
import com.example.hippo.ui.SecurePrefs

class App : Application(){
    override fun onCreate() {
        super.onCreate()
        SecurePrefs.createEncryptedPreferences(context = this)
    }
} 

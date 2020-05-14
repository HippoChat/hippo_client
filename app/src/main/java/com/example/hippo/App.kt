package com.example.hippo

import android.app.Application
import com.example.hippo.db.entity.User
import com.example.hippo.db.getAppDatabaseInstance
import com.example.hippo.ui.SecurePrefs

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        SecurePrefs.createEncryptedPreferences(context = this)
        getAppDatabaseInstance().userDao().insertAll(
            User(123, "Jim", "18-25", "ru-RU", ByteArray(0))
        ).subscribe()
    }
} 

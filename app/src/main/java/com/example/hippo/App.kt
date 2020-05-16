package com.example.hippo

import android.app.Application
import com.example.hippo.db.entity.Message
import com.example.hippo.db.getAppDatabaseInstance
import com.example.hippo.ui.SecurePrefs
import io.socket.client.IO
import io.socket.client.Socket
import org.json.JSONObject

class App : Application() {
    lateinit var socket: Socket

    override fun onCreate() {
        super.onCreate()
        SecurePrefs.createEncryptedPreferences(context = this)

        socket = IO.socket(BuildConfig.SOCK_URL)
        socket.connect()

        socket.on("onMessage") {
            val data = it[0] as JSONObject
            val sender: Int = data.getInt("sender_id")
            val receiver: Int = data.getInt("receiver_id")
            val message: String = data.getString("message")
            getAppDatabaseInstance().messageDao()
                .insert(Message(sender = sender, message = message, receiver = receiver))
        }
        socket.on("userInfo") {}
    }
} 

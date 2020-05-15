package com.example.hippo.ui.main

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hippo.R
import kotlinx.android.synthetic.main.chat_activity.*


class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chat_activity)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.stackFromEnd = true
        rv_messages.layoutManager = layoutManager

        setSupportActionBar(chatBar)

        rv_messages.adapter = ChatMessageAdapter(
            this,
            listOf(Message("Hello", true),
                Message("Goodbye", false),
                Message("Really Long Message, Like hecking long, as in, extremely fucking long long long message of longness", false),
                Message("Hello", true),
                Message("Hello", true),
                Message("Hello", true),
                Message("Hello", true),
                Message("Hello", true),
                Message("Hello", true),
                Message("Hello", true),
                Message("Hello", true),
                Message("Hello", true),
                Message("Hello", false),
                Message("Hello", true),
                Message("Hello", false),
                Message("Hello", true),
                Message("Hello", true),
                Message("Hello", true),
                Message("Hello", true),
                Message("Hello", true),
                Message("Hello", true)))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.chat_menu, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
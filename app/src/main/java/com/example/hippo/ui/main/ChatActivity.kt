package com.example.hippo.ui.main

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.Menu
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hippo.R
import com.example.hippo.util.MarginItemDecoration
import kotlinx.android.synthetic.main.chat_activity.*


class ChatActivity : AppCompatActivity() {

    private lateinit var etMessageField: EditText
    private lateinit var ibtSend: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chat_activity)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.stackFromEnd = true
        rv_messages.layoutManager = layoutManager

        rv_messages.addItemDecoration(
            MarginItemDecoration(
                resources.getDimension(R.dimen.dp_8).toInt()
            )
        )

        setSupportActionBar(chatBar)

        rv_messages.adapter = ChatMessageAdapter(
            this,
            listOf(
                Message("Hello", true),
                Message("Goodbye", false),
                Message(
                    "Really Long Message, Like hecking long, as in, extremely fucking long long long message of longness",
                    false
                ),
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
                Message("Hello", true)
            )
        )

        etMessageField = findViewById(R.id.et_message_field)
        ibtSend = findViewById(R.id.ibt_send)

        ibtSend.setOnClickListener{
//            TODO: send message to server
            val t = Toast.makeText(this, "Your message was sent :)", Toast.LENGTH_LONG)
            t.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.chat_menu, menu)

        val item1 = menu?.getItem(0)
        val item2 = menu?.getItem(1)
        val item3 = menu?.getItem(2)
        val s1 = SpannableString("Finish chat")
        val s2 = SpannableString("Add to friends")
        val s3 = SpannableString("Report user")
        s1.setSpan(ForegroundColorSpan(Color.WHITE), 0, s1.length, 0)
        s2.setSpan(ForegroundColorSpan(Color.WHITE), 0, s2.length, 0)
        s3.setSpan(ForegroundColorSpan(Color.WHITE), 0, s3.length, 0)
        if (item1 != null && item2 != null && item3 != null) {
            item1.title = s1
            item2.title = s2
            item3.title = s3
        }

        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
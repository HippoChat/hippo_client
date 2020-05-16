package com.example.hippo.ui.main

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.view.Menu
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hippo.App
import com.example.hippo.R
import com.example.hippo.api.model.SendMessage
import com.example.hippo.db.entity.Message
import com.example.hippo.db.getAppDatabaseInstance
import com.example.hippo.ui.SecurePrefs
import com.example.hippo.util.MarginItemDecoration
import com.example.hippo.util.subscribeIoObserveMain
import com.google.gson.Gson
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.chat_activity.*


class ChatActivity : AppCompatActivity() {

    private lateinit var etMessageField: EditText
    private lateinit var ibtSend: ImageButton
    private var messageList: ArrayList<Message> = arrayListOf()
    private var messageAdapter: ChatMessageAdapter = ChatMessageAdapter(this, messageList)

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

        rv_messages.adapter = messageAdapter
        val peerId: Int = intent.getIntExtra("id", 0)

        etMessageField = findViewById(R.id.et_message_field)
        ibtSend = findViewById(R.id.ibt_send)

        ibtSend.setOnClickListener {
            val message = SendMessage(peerId, etMessageField.text.toString())
            (application as App).socket.emit("sendMessage", Gson().toJson(message))
            application.getAppDatabaseInstance().messageDao().insert(
                Message(
                    sender = SecurePrefs.getId(),
                    receiver = peerId,
                    message = etMessageField.text.toString()
                )
            ).subscribe()
            etMessageField.text.clear()
        }

        getAppDatabaseInstance().messageDao().getChatHistory(peerId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                messageList.addAll(it)
                messageAdapter.notifyDataSetChanged()
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
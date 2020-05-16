package com.example.hippo.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hippo.R
import com.example.hippo.db.entity.Message
import com.example.hippo.db.getAppDatabaseInstance
import com.example.hippo.util.subscribeIoObserveMain
import kotlinx.android.synthetic.main.chat_list_pane.*
import java.util.*

class ChatPaneFragment(val peerId: Int) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.chat_list_pane, container, false)

        root.setOnClickListener {
            val chat: Intent = Intent(activity, ChatActivity::class.java)
            chat.putExtra("id", peerId)
            startActivity(chat)
        }

        val db = context!!.getAppDatabaseInstance().messageDao()

        db.getLastMessage(peerId)
            .subscribeIoObserveMain()
            .subscribe { msg: Optional<Message> ->
                if (msg.isPresent)
                    tv_user_last_msg.text = msg.get().message
            }

        return root
    }
}
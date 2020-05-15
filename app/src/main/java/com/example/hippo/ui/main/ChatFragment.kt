package com.example.hippo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.hippo.R
import kotlinx.android.synthetic.main.chat_fragment.*

class ChatFragment : Fragment() {
    private lateinit var ivSearchFriend: ImageView
    private lateinit var tvSearch: TextView
    private lateinit var btSearch: Button

    private lateinit var tvFinishChat: TextView
    private lateinit var btFinish: Button

    private var isChatting = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.chat_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivSearchFriend = view.findViewById(R.id.iv_chat_empty)
        tvSearch = view.findViewById(R.id.tv_search_friend)
        btSearch = view.findViewById(R.id.bt_search)

        tvFinishChat = view.findViewById(R.id.tv_finish_chat)
        btFinish = view.findViewById(R.id.bt_finish)

        btSearch.setOnClickListener {
            isChatting = true
            changeSearchFriendView()
        }

        btFinish.setOnClickListener {
            isChatting = false
            changeSearchFriendView()
        }

        changeSearchFriendView()
    }

    private fun changeSearchFriendView() {
        if (isChatting) {
            ivSearchFriend.visibility = View.GONE
            tvSearch.visibility = View.GONE
            btSearch.visibility = View.GONE

            tvFinishChat.visibility = View.VISIBLE
            btFinish.visibility = View.VISIBLE
            chat_pane.visibility = View.VISIBLE
        } else {
            ivSearchFriend.visibility = View.VISIBLE
            tvSearch.visibility = View.VISIBLE
            btSearch.visibility = View.VISIBLE

            tvFinishChat.visibility = View.GONE
            btFinish.visibility = View.GONE
            chat_pane.visibility = View.GONE
        }
    }
}
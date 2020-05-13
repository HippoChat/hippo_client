package com.example.hippo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.hippo.R
import kotlinx.android.synthetic.main.chat_fragment.*

class ChatFragment : Fragment(){
    private lateinit var ivSearchFriend: ImageView
    private lateinit var tvSearch: TextView
    private lateinit var btSearch: Button

    private var isChatting = true

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

        ivSearchFriend = view.findViewById(R.id.ivChatEmpty)
        tvSearch = view.findViewById(R.id.tvSearchFriend)
        btSearch = view.findViewById(R.id.bt_search)

        changeSearchFriendView()
    }

    private fun changeSearchFriendView(){
        if (isChatting){
            ivSearchFriend.visibility = View.GONE
            tvSearch.visibility = View.GONE
            btSearch.visibility = View.GONE
        } else {
            ivSearchFriend.visibility = View.VISIBLE
            tvSearch.visibility = View.VISIBLE
            btSearch.visibility = View.VISIBLE
        }
    }
}
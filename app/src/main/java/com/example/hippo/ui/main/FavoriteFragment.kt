package com.example.hippo.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hippo.R
import kotlinx.android.synthetic.main.favorite_fragment.*

class FavoriteFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.favorite_fragment, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO: PLACEHOLDER?
        chat_pane_1.setOnClickListener { startActivity(Intent(activity, ChatActivity::class.java)) }
        chat_pane_2.setOnClickListener { startActivity(Intent(activity, ChatActivity::class.java)) }
        chat_pane_3.setOnClickListener { startActivity(Intent(activity, ChatActivity::class.java)) }
    }
}
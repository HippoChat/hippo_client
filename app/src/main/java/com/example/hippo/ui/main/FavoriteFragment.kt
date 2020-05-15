package com.example.hippo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.hippo.R
import kotlinx.android.synthetic.main.favorite_fragment.*

class FavoriteFragment : Fragment() {
    private val hasFriends = true

    private lateinit var ivNoFavFriends: ImageView
    private lateinit var tvNoFavFriends: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.favorite_fragment, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ivNoFavFriends = view.findViewById(R.id.iv_no_favorite_friends)
        tvNoFavFriends = view.findViewById(R.id.tv_no_friends)

        changeFavFriendView()
    }


    private fun changeFavFriendView() {
        if (hasFriends) {
            fav_chat_pane.visibility = View.VISIBLE
            ivNoFavFriends.visibility = View.GONE
            tvNoFavFriends.visibility = View.GONE
        } else {
            fav_chat_pane.visibility = View.GONE
            ivNoFavFriends.visibility = View.VISIBLE
            tvNoFavFriends.visibility = View.VISIBLE
        }
    }
}
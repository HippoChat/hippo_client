package com.example.hippo.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.hippo.R
import kotlinx.android.synthetic.main.favorite_fragment.*

class FavoriteFragment : Fragment(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.favorite_fragment, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: Replace with a chatPane (the layout is kinda done, need to write a fragment for it
        var test: ArrayList<String> = arrayListOf("Test", "Test2")
        userView.adapter = ArrayAdapter(this.requireContext(), android.R.layout.simple_list_item_1, test)
    }
}
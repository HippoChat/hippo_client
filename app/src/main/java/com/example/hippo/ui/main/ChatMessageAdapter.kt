package com.example.hippo.ui.main

import android.content.Context
import android.graphics.PorterDuff
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hippo.R
import com.example.hippo.util.MarginItemDecoration
import kotlinx.android.synthetic.main.chat_bubble.view.*


class ChatMessageAdapter(private var context: Context, private var elements: List<Message>) : RecyclerView.Adapter<ChatMessageAdapter.ViewHolder>() {
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.chat_bubble, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return elements.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.tv_user_last_msg.text = elements[position].message
        if(elements[position].received) {
            holder.view.backLayout.background.setColorFilter(
                context.resources.getColor(R.color.chatBubbleDark),
                PorterDuff.Mode.SRC_IN
            )
            holder.view.alignmentLayout.gravity = Gravity.START
        } else {
            holder.view.backLayout.background.setColorFilter(
                context.resources.getColor(R.color.chatBubbleLight),
                PorterDuff.Mode.SRC_IN
            )
            holder.view.alignmentLayout.gravity = Gravity.END
        }
    }
}
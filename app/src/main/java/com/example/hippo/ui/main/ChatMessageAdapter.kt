package com.example.hippo.ui.main

import android.content.Context
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hippo.R
import kotlinx.android.synthetic.main.chat_bubble.view.*

class ChatMessageAdapter(private var context: Context, private var elements: List<Message>) : RecyclerView.Adapter<ChatMessageAdapter.ViewHolder>() {
    /*
    val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: inflater.inflate(R.layout.chat_bubble, parent, false)
        //val yOffset = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20f, context.resources.displayMetrics)
        view.message.text = elements[position].message
        view.layoutParams.width = view.message.measuredWidth
        //view.message.measure(0, 0)
        //view.bubble.layoutParams.width = view.message.measuredWidth + view.message.marginRight * 2
        //view.bubble.layoutParams.height = view.message.measuredHeight + yOffset.toInt()
        return view
    }

    override fun getItem(position: Int): Any {
        return elements[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return elements.size
    }
     */

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.chat_bubble, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return elements.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.message.text = elements[position].message
        if(elements[position].received) {
            holder.view.background.setColorFilter(
                context.resources.getColor(R.color.chatBubbleDark),
                PorterDuff.Mode.SRC_IN
            )
        } else {
            holder.view.background.setColorFilter(
                context.resources.getColor(R.color.chatBubbleLight),
                PorterDuff.Mode.SRC_IN
            )
        }
    }
}
package com.example.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.calendar_ui.R
import com.example.dataclass.plan_data

class plan_adapter (private val plandataList: ArrayList<plan_data>) :
        RecyclerView.Adapter<plan_adapter.Holder>() {
    var mPosition = 0

    fun getPosition(): Int {
        return mPosition
    }

    fun setPosition(position: Int) {
        mPosition = position
    }

    fun addItem(speicaldata: plan_data) {
        plandataList.add(speicaldata)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        if (position > 0) {
            plandataList.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.plan_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return plandataList.size
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val plan_title = itemView.findViewById<TextView>(R.id.plan_title)
        private val plan_do = itemView.findViewById<TextView>(R.id.doing_tv)

        fun bind(Data: plan_data) {

            plan_title?.text = Data.title
            plan_do?.text = Data.doing
        }
    }

    override fun onBindViewHolder(holder: plan_adapter.Holder, position: Int) {
        holder?.bind(plandataList.get(position))
    }
}
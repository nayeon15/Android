package com.example.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.calendar_ui.R
import com.example.dataclass.picu_data

class picu_adapter (private val picudataList: ArrayList<picu_data>) :
        RecyclerView.Adapter<picu_adapter.Holder>() {
    var mPosition = 0

    fun getPosition(): Int {
        return mPosition
    }

    fun setPosition(position: Int) {
        mPosition = position
    }

    fun addItem(picudata: ArrayList<picu_data>) {
        picudataList.addAll(picudata)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        if (position > 0) {
            picudataList.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(picudataList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.picu_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return picudataList.size
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userPhoto = itemView.findViewById<ImageView>(R.id.profite_img)
        private val userName = itemView.findViewById<TextView>(R.id.user_name_tv)
        private val userReason = itemView.findViewById<TextView>(R.id.user_reason_tv)

        fun bind(picuData: picu_data) {

            userPhoto.setImageResource(R.drawable.people)
            userName?.text = picuData.name
            userReason?.text = picuData.reason
        }
    }


}


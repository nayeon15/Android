package com.example.gramo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val context: BottomDialogFragment, private val dataList: ArrayList<Data>) :
    RecyclerView.Adapter<CustomAdapter.Holder>() {
    var mPosition = 0

    fun getPosition(): Int {
        return mPosition
    }

    fun setPosition(position: Int) {
        mPosition = position
    }

    fun addItem(data: Data) {
        dataList.add(data)
        notifyDataSetChanged()
    }

    fun removeItem(position: Int) {
        if (position > 0) {
            dataList.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(dataList[position], context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.picu_rv_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userPhoto = itemView.findViewById<ImageView>(R.id.profite_img)
        private val userName = itemView.findViewById<TextView>(R.id.user_name_tv)
        private val userReason = itemView.findViewById<TextView>(R.id.user_reason_tv)

        fun bind(data: Data, context: BottomDialogFragment) {
            /*if (dataVo.photo != "") {
                val resourceId =
                    context.resources.getIdentifier(dataVo.photo, "drawable", R.drawable.people)

                if (resourceId > 0) {
                    userPhoto.setImageResource(resourceId)
                } else {
                    userPhoto.setImageResource(R.mipmap.ic_launcher_round)
                }
            } else {
                userPhoto.setImageResource(R.mipmap.ic_launcher_round)
            }*/

            userPhoto.setImageResource(R.drawable.people)
            userName?.text = data.name
            userReason?.text = data.reason
        }
    }


}


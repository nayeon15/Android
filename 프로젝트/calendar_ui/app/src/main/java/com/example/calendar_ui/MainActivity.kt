package com.example.calendar_ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.adapter.picu_adapter
import com.example.adapter.plan_adapter
import com.example.dataclass.picu_data
import com.example.dataclass.plan_data

class MainActivity : AppCompatActivity() {

    var userlist = arrayListOf<picu_data>(
            picu_data("박나연", "몸이 아파요", "people")
    )

    var planlist = arrayListOf<plan_data>(
            plan_data("오늘은", "동아리 청소")
    )

    val mAdapter = picu_adapter(this, userlist)
    val nAdapter = plan_adapter(this, planlist)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            view.picu_rv.adapter = mAdapter
            view.special_rv.adapter = nAdapter

            view.picu_rv.setHasFixedSize(true)

            view.special_rv.setHasFixedSize(true)

            view.plus_btn.setOnClickListener {
                picu_input.visibility = if (picu_input.visibility == View.VISIBLE){ View.GONE }
                else{ View.VISIBLE }
            }

            view.plus_btn2.setOnClickListener {
                special_input.visibility = if (special_input.visibility == View.VISIBLE){ View.GONE }
                else{ View.VISIBLE }
            }

            return view

        }
    }
}
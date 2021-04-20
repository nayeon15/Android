package com.example.gramo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_bottom_dialog.*
import kotlinx.android.synthetic.main.fragment_bottom_dialog.view.*
import kotlinx.android.synthetic.main.activity_main.*



class BottomDialogFragment(val itemClick: (Int) -> Unit) : BottomSheetDialogFragment() {
    var userList = arrayListOf<Data>(
        Data("박나연", "몸이 아파요", "people")
    )
    val mAdapter = CustomAdapter(this, userList)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_bottom_dialog, container, false)

        view.recycler_view.adapter = mAdapter

        val layout = LinearLayoutManager(activity)
        view.recycler_view.layoutManager = layout
        view.recycler_view.setHasFixedSize(true)

        view.plus_btn.setOnClickListener {
            mAdapter.addItem(Data("학생임", "@null", "people"))
            test.visibility = view.visibility
        }
        return view

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.plus_btn2.setOnClickListener {
            itemClick(1)
            dialog?.dismiss()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view!!.plus_btn.setOnClickListener {

        }
    }

}
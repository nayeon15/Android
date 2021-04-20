package com.example.gramo

import android.app.ProgressDialog.show
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calendarView.setOnDateChangedListener { materialCalendarView: MaterialCalendarView, calendarDay: CalendarDay, b: Boolean ->
            val bottomDialogFragment: BottomDialogFragment = BottomDialogFragment {
                when (it){
                    0 ->
                }
            }
            bottomDialogFragment.show(supportFragmentManager, bottomDialogFragment.tag)
        }
    }
}
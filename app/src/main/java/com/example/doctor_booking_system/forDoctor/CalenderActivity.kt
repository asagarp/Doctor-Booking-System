package com.example.doctor_booking_system.forDoctor

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.doctor_booking_system.R
import android.widget.CalendarView
import android.widget.TextView

class CalenderActivity : AppCompatActivity() {
    private lateinit var calendarView: CalendarView
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calender)

        calendarView = findViewById(R.id.calendarView2)
        textView = findViewById(R.id.selected_date_text)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.calendar_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        calendarView.setOnDateChangeListener { _, year, month, day ->
            val date = ("%02d".format(day) + "-" + "%02d".format((month + 1)) + "-" + year)
            textView.text = date
        }
    }
}

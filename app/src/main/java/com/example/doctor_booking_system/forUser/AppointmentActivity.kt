package com.example.doctor_booking_system.forUser

import android.os.Build
import android.os.Bundle
import android.widget.ListView
//import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//import androidx.recyclerview.widget.LinearLayoutManager
import com.example.doctor_booking_system.R
//import com.example.doctor_booking_system.forDoctor.MyTimeSlotAdapter
//import com.example.doctor_booking_system.forDoctor.TimeSlot
import java.util.ArrayList

class AppointmentActivity : AppCompatActivity() {
//    private lateinit var timeSlotAdapter: MyTimeSlotAdapter
//    private val timeSlotList: MutableList<TimeSlot> = mutableListOf()
    private lateinit var bookedDoctorsAdapter: BookedDoctorsAdapter
    private lateinit var listView: ListView

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment)

        // Apply system window insets to adjust padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.appointment_list_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize views
        listView = findViewById(R.id.list_view)

        // Retrieve the booked doctors list from the intent
        val bookedDoctors = ArrayList(BookedDoctorsManager.getBookedDoctors())

        // Initialize and set the adapter
        bookedDoctorsAdapter = BookedDoctorsAdapter(this, bookedDoctors)
        listView.adapter = bookedDoctorsAdapter

        // Assuming timeSlotList is populated from a data source
//        timeSlotList.addAll(generateDummySlots())

//        timeSlotAdapter = MyTimeSlotAdapter(timeSlotList) { slot, position ->
//            bookSlot(slot, position)
//        }

//        list_view.apply {
//            layoutManager = LinearLayoutManager(this@AppointmentActivity)
//            adapter = timeSlotAdapter
//        }
    }

//    private fun generateDummySlots(): List<TimeSlot> {
//         Generate some dummy data for slots
//        return listOf(
//            TimeSlot("09:00 AM"),
//            TimeSlot("10:00 AM"),
//            TimeSlot("11:00 AM")
//        )
    }

//    private fun bookSlot(slot: TimeSlot, position: Int) {
//        if (slot.isBooked) {
//            Toast.makeText(this, "Slot already booked", Toast.LENGTH_SHORT).show()
//        } else {
//            slot.isBooked = true
//            slot.bookedBy = "PatientID123" // Replace with actual patient ID or Name
//            timeSlotAdapter.notifyItemChanged(position)
//            Toast.makeText(this, "Slot booked successfully", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//}


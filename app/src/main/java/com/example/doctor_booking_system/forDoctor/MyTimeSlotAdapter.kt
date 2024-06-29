/*package com.example.doctor_booking_system.forDoctor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.doctor_booking_system.R

class MyTimeSlotAdapter(
    private val timeSlotList: List<TimeSlot>,
    private val onSlotClick: (TimeSlot, Int) -> Unit
) : RecyclerView.Adapter<MyTimeSlotAdapter.TimeSlotViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeSlotViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_time_slot, parent, false)
        return TimeSlotViewHolder(view)
    }

    override fun onBindViewHolder(holder: TimeSlotViewHolder, position: Int) {
        val timeSlot = timeSlotList[position]
        holder.bind(timeSlot, position)
    }

    override fun getItemCount(): Int = timeSlotList.size

    inner class TimeSlotViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val timeTextView: TextView = itemView.findViewById(R.id.text_time_slot)
        private val statusTextView: TextView = itemView.findViewById(R.id.text_status)

        fun bind(timeSlot: TimeSlot, position: Int) {
            timeTextView.text = timeSlot.slotTime
            statusTextView.text = if (timeSlot.isBooked) "Booked by ${timeSlot.bookedBy}" else "Available"

            itemView.setOnClickListener {
                onSlotClick(timeSlot, position)
            }
        }
    }
}
*/
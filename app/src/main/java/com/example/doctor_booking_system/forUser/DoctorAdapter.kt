package com.example.doctor_booking_system.forUser

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.doctor_booking_system.R
import com.example.doctor_booking_system.forDoctor.DoctorProfileActivity
import java.util.ArrayList

class DoctorAdapter(
    context: Context,
    doctors: ArrayList<Doctor>,
    private val callback: DoctorsListActivity
) : ArrayAdapter<Doctor>(context, 0, doctors) {

    @SuppressLint("ResourceType")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val viewHolder: ViewHolder

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.doctor_list, parent, false)
            viewHolder = ViewHolder(
                view.findViewById(R.id.doctor_view_title),
                view.findViewById(R.id.text_view_description),
                view.findViewById(R.id.doctor_item_image),
                view.findViewById(R.id.appointment_button)
            )
            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }

        val doctor = getItem(position)


        //check if the doctor meets a specific condition(eg, speciality)
        if (doctor?.specialty == "Cardiology") {
            // Example: Change background color for Cardiology specialists
            view?.setBackgroundResource(R.color.blue)
        } else {
            // Reset background to default for other doctors
            view?.setBackgroundResource(android.R.color.transparent)
        }


        // Populate views if doctor is not null
        doctor?.let {
            viewHolder.nameTextView.text = it.name
            viewHolder.specialtyTextView.text = it.specialty
            viewHolder.imageView.setImageResource(it.imageID)
        }


        // Handle click to book doctor
        view?.setOnClickListener {
            // Pass booked doctors list to AppointmentActivity
            val intent = Intent(context, DoctorProfileActivity::class.java)
            intent.putExtra("doctor", doctor)
            context.startActivity(intent)
        }

        // Handle click to book doctor
        viewHolder.bookButton.setOnClickListener {
            doctor?.let { callback.onBookDoctor(it) }
        }


        return view!!
    }

    private class ViewHolder(
        val nameTextView: TextView,
        val specialtyTextView: TextView,
        val imageView: ImageView,
        val bookButton:Button
    )
}

package com.example.doctor_booking_system.forDoctor

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.doctor_booking_system.R
import com.example.doctor_booking_system.forUser.UserProfileActivity
import java.util.ArrayList

class PatientAdapter(
    context: Context,
    patients: ArrayList<Patient>,
    private val callback: PatientListActivity
) : ArrayAdapter<Patient>(context, 0, patients) {

    @SuppressLint("ResourceType")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val viewHolder: ViewHolder

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.user_list, parent, false)
            viewHolder = ViewHolder(
                view.findViewById(R.id.doctor_view_title),
                view.findViewById(R.id.text_view_description),
                view.findViewById(R.id.user_item_image)
            )
            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }

        val patient = getItem(position)

        // Populate views if doctor is not null
        patient?.let {
            viewHolder.nameTextView.text = it.name
            viewHolder.specialtyTextView.text = it.condition
            viewHolder.imageView.setImageResource(it.imageID)
        }

        // Handle click to book doctor
        view?.setOnClickListener {
            // Pass booked doctors list to AppointmentActivity
            val intent = Intent(context, UserProfileActivity::class.java)
            intent.putExtra("doctor", patient)
            context.startActivity(intent)
        }

        return view!!
    }

    private class ViewHolder(
        val nameTextView: TextView,
        val specialtyTextView: TextView,
        val imageView: ImageView
    )
}

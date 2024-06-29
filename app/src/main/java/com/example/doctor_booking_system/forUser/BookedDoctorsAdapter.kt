package com.example.doctor_booking_system.forUser

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.doctor_booking_system.R

class BookedDoctorsAdapter(context: Context, doctors: List<Doctor>) : ArrayAdapter<Doctor>(context, 0, doctors) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val viewHolder: ViewHolder

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.doctor_list, parent, false)
            viewHolder = ViewHolder(
                view.findViewById(R.id.doctor_view_title),
                view.findViewById(R.id.text_view_description),
                view.findViewById(R.id.doctor_item_image)
            )
            view.tag = viewHolder
        } else {
            viewHolder = view.tag as ViewHolder
        }

        val doctor = getItem(position)
        // Populate views if doctor is not null
        doctor?.let {
            viewHolder.nameTextView.text = it.name
            viewHolder.specialtyTextView.text = it.specialty
            viewHolder.imageView.setImageResource(it.imageID)
        }

        return view!!
    }

    private class ViewHolder(
        val nameTextView: TextView,
        val specialtyTextView: TextView,
        val imageView: ImageView
    )
}



package com.example.doctor_booking_system.forUser

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.ImageView
import android.widget.TextView
import com.example.doctor_booking_system.R

class SearchAdapter(context: Context, private val doctors: List<Doctor>) : ArrayAdapter<Doctor>(context, 0, doctors) {

    private var filteredDoctors: List<Doctor> = doctors

    override fun getCount(): Int {
        return filteredDoctors.size
    }

    override fun getItem(position: Int): Doctor? {
        return filteredDoctors[position]
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.doctor_list, parent, false)
        val doctor = getItem(position)

        val nameTextView = view.findViewById<TextView>(R.id.doctor_view_title)
        val specialtyTextView = view.findViewById<TextView>(R.id.text_view_description)
        val doctorImageView = view.findViewById<ImageView>(R.id.doctor_item_image)

        doctor?.let {
            nameTextView.text = it.name
            specialtyTextView.text = it.specialty
            doctorImageView.setImageResource(it.imageID)
        }

        return view
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val query = constraint?.toString()?.lowercase()?.trim()
                val results = FilterResults()
                results.values = if (query.isNullOrEmpty()) {
                    doctors
                } else {
                    doctors.filter {
                        it.name.lowercase().contains(query) || it.specialty.lowercase().contains(query)
                    }
                }
                return results
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filteredDoctors = results?.values as List<Doctor>
                notifyDataSetChanged()
            }
        }
    }
}

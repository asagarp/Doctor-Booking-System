package com.example.doctor_booking_system.forUser

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.doctor_booking_system.R
import java.util.ArrayList

class DoctorsListActivity : AppCompatActivity() {

    private val doctorsList: List<Doctor> = listOf(
        Doctor("Dr. Sagar Chhantyal", "Cardiologist", R.drawable.doctor),
        Doctor("Dr. Rabin Darlami", "Pediatrician", R.drawable.doctor),
        Doctor("Dr. Nelson Gurung", "Dermatologist", R.drawable.doctor),
        Doctor("Dr. Nirmal Gurung", "Pediatrician", R.drawable.doctor),
        Doctor("Dr. Samip Kathayat", "Gyanakologist", R.drawable.doctor),
        Doctor("Dr. Geeta Shrestha", "Dermatologist", R.drawable.doctor)
        // Add more doctors as needed
    )

    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctors_list)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.doctors_list_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // Create an instance of DoctorAdapter and set it to the ListView
        val adapter = DoctorAdapter(this, ArrayList(doctorsList), this)

        // Find the ListView in the layout
        val doctorsListView: ListView = findViewById(R.id.list_view)
        doctorsListView.adapter = adapter


    }

    fun onBookDoctor(doctor: Doctor) {
        BookedDoctorsManager.addDoctor(doctor)
    }
}

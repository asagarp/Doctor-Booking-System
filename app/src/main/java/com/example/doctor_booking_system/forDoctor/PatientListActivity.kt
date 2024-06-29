package com.example.doctor_booking_system.forDoctor

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.doctor_booking_system.R
import java.util.ArrayList

class PatientListActivity : AppCompatActivity() {

    private val patientsList: List<Patient> = listOf(
        Patient("Dr. Sagar Chhantyal", "Cardiologist", R.drawable.doctor),
        Patient("Dr. Rabin Darlami", "Pediatrician", R.drawable.doctor),
        Patient("Dr. Nelson Gurung", "Dermatologist", R.drawable.doctor),
        Patient("Dr. Nirmal Gurung", "Pediatrician", R.drawable.doctor),
        Patient("Dr. Samip Kathayat", "Gyanakologist", R.drawable.doctor),
        Patient("Dr. Geeta Shrestha", "Dermatologist", R.drawable.doctor)
        // Add more doctors as needed
    )

    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_list)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.users_list_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // Create an instance of DoctorAdapter and set it to the ListView
        val adapter = PatientAdapter(this, ArrayList(patientsList), this)

        // Find the ListView in the layout
        val doctorsListView: ListView = findViewById(R.id.list_view_1)
        doctorsListView.adapter = adapter


    }

}

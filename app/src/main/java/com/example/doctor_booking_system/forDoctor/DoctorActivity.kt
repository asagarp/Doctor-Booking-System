package com.example.doctor_booking_system.forDoctor

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.doctor_booking_system.LoginActivity
import com.example.doctor_booking_system.R

class DoctorActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_doctor)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.doctor_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val profileButton = findViewById<Button>(R.id.profile)
        profileButton.setOnClickListener {
            val intent = Intent(this, DoctorProfileActivity::class.java)
            startActivity(intent)
        }
        val patientButton= findViewById<Button>(R.id.patients)
        patientButton.setOnClickListener{
           val intent = Intent(this, PatientListActivity::class.java)
            startActivity(intent)
        }
        val signoutButton = findViewById<Button>(R.id.signout_button)
        signoutButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        val calenderButton = findViewById<Button>(R.id.calendar)
        calenderButton.setOnClickListener {
            val intent = Intent(this, CalenderActivity::class.java)
            startActivity(intent)
        }
        val patientRequestButton = findViewById<Button>(R.id.patient_request)
        patientRequestButton.setOnClickListener {
            val intent = Intent(this, PatientRequestActivity::class.java)
            startActivity(intent)
        }
    }
}
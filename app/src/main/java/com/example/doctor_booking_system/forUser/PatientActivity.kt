package com.example.doctor_booking_system.forUser

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.doctor_booking_system.LoginActivity
import com.example.doctor_booking_system.R

class PatientActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_patient)

        setupWindowInsets()
        setupButtonListeners()
    }

    private fun setupWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.patient_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun setupButtonListeners() {
        findViewById<Button>(R.id.button).setOnClickListener {
            launchActivity(DoctorsListActivity::class.java, "Button clicked, launching DoctorsListActivity")
        }

        findViewById<Button>(R.id.search).setOnClickListener {
            launchActivity(SearchActivity::class.java)
        }

        findViewById<Button>(R.id.signout_button).setOnClickListener {
            launchActivity(LoginActivity::class.java)
        }

        findViewById<Button>(R.id.appointments).setOnClickListener {
            val intent = Intent(this, AppointmentActivity::class.java)
            intent.getParcelableArrayListExtra("bookedDoctors", Doctor::class.java) ?: ArrayList()
            startActivity(intent)
        }

        findViewById<Button>(R.id.profile).setOnClickListener{
            launchActivity(UserProfileActivity::class.java)
        }
    }

    private fun launchActivity(activityClass: Class<*>, logMessage: String? = null) {
        logMessage?.let { Log.d("PatientActivity", it) }
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }
}

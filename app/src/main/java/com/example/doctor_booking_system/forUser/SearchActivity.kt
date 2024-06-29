package com.example.doctor_booking_system.forUser

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.doctor_booking_system.R

class SearchActivity : AppCompatActivity() {

    // Sample list of doctors (replace with your actual data source)
    private val doctorsList: List<Doctor> = listOf(
        Doctor("Dr. Sagar Chhantyal", "Cardiologist", R.drawable.doctor),
        Doctor("Dr. Rabin Darlami", "Pediatrician", R.drawable.doctor),
        Doctor("Dr. Nelson Gurung", "Dermatologist", R.drawable.doctor),
        Doctor("Dr. Nabin Khanal", "Orthologist", R.drawable.doctor),
        Doctor("Dr. Samip Kathayat", "Gyanakologist", R.drawable.doctor),
        Doctor("Dr. Geeta Shrestha", "Dermatologist", R.drawable.doctor),
        Doctor("Dr. Nirmal Gurung", "Pediatrician", R.drawable.doctor)
        // Add more doctors as needed
    )

    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.search_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find the ListView in the layout
        val doctorsListView: ListView = findViewById(R.id.listView)

        // Create an instance of DoctorAdapter and set it to the ListView
        val adapter = SearchAdapter(this, doctorsList)
        doctorsListView.adapter = adapter

        // Find the SearchView in the layout
        val searchView: SearchView = findViewById(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return true
            }
        })
    }
}

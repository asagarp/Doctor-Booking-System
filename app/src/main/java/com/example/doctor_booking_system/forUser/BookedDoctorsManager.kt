package com.example.doctor_booking_system.forUser

object BookedDoctorsManager {
    private val bookedDoctors = mutableListOf<Doctor>()

    fun addDoctor(doctor: Doctor) {
        bookedDoctors.add(doctor)
    }

    fun getBookedDoctors(): List<Doctor> {
        return bookedDoctors
    }
}

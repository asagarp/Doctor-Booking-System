package com.example.doctor_booking_system.data.remote

import com.example.doctor_booking_system.data.remote.ApiClient.apiService

class ApiHelper {
    fun getUser(userId: Int) = apiService.getUser(userId)
}
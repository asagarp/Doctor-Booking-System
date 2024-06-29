package com.example.doctor_booking_system.data.repository

import com.example.doctor_booking_system.data.remote.ApiHelper

class UserRepository(private val apiHelper: ApiHelper) {
    fun getUser(userId: Int) = apiHelper.getUser(userId)
}

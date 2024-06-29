package com.example.doctor_booking_system.data.remote

import com.example.doctor_booking_system.data.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("users/{userId}")
    fun getUser(@Path("userId") userId: Int): Call<User>
}
package com.example.doctor_booking_system.ViewModal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import com.example.doctor_booking_system.data.model.User
import com.example.doctor_booking_system.data.repository.UserRepository
import com.example.doctor_booking_system.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {

    val user = MutableLiveData<Resource<User>>()

    fun fetchUser(userId: Int) {
        user.postValue(Resource.loading(null))
        val coroutineScope = CoroutineScope(Dispatchers.IO)
        coroutineScope.launch {
            val response = userRepository.getUser(userId).execute()
            user.postValue(handleResponse(response))
        }
    }

    private fun handleResponse(response: Response<User>): Resource<User> {
        return if (response.isSuccessful) {
            Resource.success(response.body())
        } else {
            Resource.error(response.message(), null)
        }
    }
}

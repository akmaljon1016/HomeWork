package com.dars.homework

import com.dars.homework.model.UserItem
import retrofit2.Call
import retrofit2.http.GET

interface NetworApi {
    @GET("users")
    fun getUsers(): Call<List<UserItem>>

}
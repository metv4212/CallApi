package com.example.callapi

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("v1/info/api")
    fun getApiInfo(): Call<stringsApi>
}
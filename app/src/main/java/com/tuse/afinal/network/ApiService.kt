package com.tuse.afinal.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import com.tuse.afinal.models.Result

private const val BASE_URL = "https://data.petabencana.id/"

val retrofit: Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

interface ApiService{
    @GET("reports")
    suspend fun getData(@Query("timeperiod") timeperoid: String) : Result
}

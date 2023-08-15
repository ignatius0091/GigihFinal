package com.tuse.afinal.network

import com.tuse.afinal.model.Geometry
import retrofit2.http.GET
import retrofit2.http.Query


interface DisasterApiService {
    @GET("reports")
    suspend fun getDisasterGeometries(@Query("timeperiod") timeperiod: String): List<Geometry>
}


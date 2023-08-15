package com.tuse.afinal.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.tuse.afinal.network.DisasterApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer{
    val disasterRepository : DisasterGeometriesRepository
}
class DefaultAppContainer() : AppContainer {
    private val baseURl = "https://data.petabencana.id/"

    val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseURl)
        .build()

    private val retrofitService: DisasterApiService by lazy{
        retrofit.create(DisasterApiService::class.java)
    }

    override val disasterRepository: DisasterGeometriesRepository by lazy{
        NetworkDisasterGeometriesRepository(retrofitService)
    }


}
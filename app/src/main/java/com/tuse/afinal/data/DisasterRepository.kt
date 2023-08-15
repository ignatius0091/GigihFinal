package com.tuse.afinal.data

import com.tuse.afinal.model.Geometry
import com.tuse.afinal.network.DisasterApiService

interface DisasterGeometriesRepository {
    suspend fun getDisasterGeometries() : List<Geometry>
}

class NetworkDisasterGeometriesRepository(private val disasterApiService: DisasterApiService): DisasterGeometriesRepository{
    override suspend fun getDisasterGeometries(): List<Geometry> = disasterApiService.getDisasterGeometries("604800")

}
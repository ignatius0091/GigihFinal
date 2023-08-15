package com.tuse.afinal.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class Geometry(
    val type: String,
    val properties: Properties,
    val coordinates: List<Double>
)

@Serializable
data class Properties(
    val pkey: String,
    @SerializedName("created_at") val createdAt: String,
    val source: String,
    val status: String,
    val url: String,
    @SerializedName("image_url") val imageUrl: String,
    @SerializedName("disaster_type") val disasterType: String,
    val reportData: ReportData,
    val tags: Tags,
    val title: String?,
    val text: String,
    @SerializedName("partner_code") val partnerCode: String?,
    @SerializedName("partner_icon") val partnerIcon: String?
)

@Serializable
data class ReportData(
    @SerializedName("report_type") val reportType: String,
    @SerializedName("flood_depth") val floodDepth: Int
)

@Serializable
data class Tags(
    @SerializedName("district_id") val districtId: String?,
    @SerializedName("region_code") val regionCode: String,
    @SerializedName("local_area_id") val localAreaId: String?,
    @SerializedName("instance_region_code") val instanceRegionCode: String
)
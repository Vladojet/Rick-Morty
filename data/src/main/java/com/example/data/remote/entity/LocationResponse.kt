package com.example.data.remote.entity

import android.os.Parcelable
import com.example.domain.models.Location
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LocationResponse(
    val info: PaginationInfo,
    val results: List<LocationDetails>
) : Parcelable

@Parcelize
data class LocationDetails(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("dimension")
    val dimension: String,
    @SerializedName("residents")
    val residents: List<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("created")
    val created: String
) : Parcelable {

    companion object {
        fun LocationDetails.mapToLocation(): Location {
            return Location(
                id = this.id,
                name = this.name,
                type = this.type,
                dimension = this.dimension,
                residents = this.residents
            )
        }
    }
}
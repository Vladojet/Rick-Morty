package com.example.data.remote.entity

import android.os.Parcelable
import com.example.domain.models.Episode
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class EpisodeResponse(
    val info: PaginationInfo,
    val results: List<EpisodeDetails>
) : Parcelable

@Parcelize
data class EpisodeDetails(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("air_date")
    val airDate: String,
    @SerializedName("episode")
    val episode: String,
    @SerializedName("characters")
    val characters: List<String>,
    @SerializedName("url")
    val url: String,
    @SerializedName("created")
    val created: String
) : Parcelable {

    companion object {
        fun EpisodeDetails.mapToEpisode(): Episode {
            return Episode (
                id = this.id,
                name = this.name,
                airDate = this.airDate,
                episodeCode = this.episode
            )
        }
    }
}
package com.example.data.remote.entity

import android.os.Parcelable
import com.example.domain.models.MultiverseCharacter
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CharactersResponse(
    @SerializedName("info")
    val info: PaginationInfo,
    @SerializedName("results")
    val results: List<MultiverseCharacterDetails>
): Parcelable

@Parcelize
data class MultiverseCharacterDetails(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("species")
    val species: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("origin")
    val origin: WorldInfo,
    @SerializedName("location")
    val location: WorldInfo,
    @SerializedName("image")
    val imageUrl: String,
    @SerializedName("episode")
    val episode: List<String>,
    @SerializedName("url")
    val charactersUrl: String,
    @SerializedName("created")
    val created: String
): Parcelable {

    companion object {
        fun MultiverseCharacterDetails.mapToCharacter(): MultiverseCharacter {
            return MultiverseCharacter(
                id = this.id,
                name = this.name,
                status = this.status,
                species = this.species,
                gender = this.gender,
                imageUrl = this.imageUrl,
                locationName = this.location.name
            )
        }
    }
}

package com.example.data.remote.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class WorldInfo(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
): Parcelable

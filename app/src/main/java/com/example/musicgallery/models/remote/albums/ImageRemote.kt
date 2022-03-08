package com.example.musicgallery.models.remote.albums

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

data class ImageRemote (
	@SerializedName("#text") val text : String?,
	@SerializedName("size") val size : String?
)
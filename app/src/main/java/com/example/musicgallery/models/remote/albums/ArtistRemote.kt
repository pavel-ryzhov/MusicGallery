package com.example.musicgallery.models.remote.albums

import com.google.gson.annotations.SerializedName

data class ArtistRemote (
	@SerializedName("name") val name : String?,
	@SerializedName("mbid") val mbid : String?,
	@SerializedName("url") val url : String?
)
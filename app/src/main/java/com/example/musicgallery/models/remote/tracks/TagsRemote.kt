package com.example.musicgallery.models.remote.tracks

import com.google.gson.annotations.SerializedName

data class TagsRemote (

	@SerializedName("tag") val tag : List<TagRemote>
)
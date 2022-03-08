package com.example.musicgallery.models.remote.tags

import com.google.gson.annotations.SerializedName

data class TagsRemoteWrapper (
	@SerializedName("toptags") val toptags : TopTagsRemote
)
package com.example.musicgallery.models.remote.tags

import com.google.gson.annotations.SerializedName

data class TopTagsRemote(
    @SerializedName("@attr") val attr : AttrRemote,
    @SerializedName("tag") val tag: List<TagRemote>
)
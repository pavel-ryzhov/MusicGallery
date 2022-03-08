package com.example.musicgallery.models.remote.albums

import com.google.gson.annotations.SerializedName

data class AlbumRemote (
    @SerializedName("name") val name : String,
    @SerializedName("mbid") val mbid : String,
    @SerializedName("url") val url : String,
    @SerializedName("artist") val artist : ArtistRemote,
    @SerializedName("image") val image : List<ImageRemote>,
    @SerializedName("@attr") val attr : AttrRemote
)
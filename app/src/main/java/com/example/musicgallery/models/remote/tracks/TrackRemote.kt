package com.example.musicgallery.models.remote.tracks

import com.example.musicgallery.models.remote.albums.ArtistRemote
import com.google.gson.annotations.SerializedName

data class TrackRemote (

    @SerializedName("streamable") val streamable : StreamableRemote,
    @SerializedName("duration") val duration : Int,
    @SerializedName("url") val url : String,
    @SerializedName("name") val name : String,
    @SerializedName("@attr") val attr : AttrRemote,
    @SerializedName("artist") val artist : ArtistRemote
)
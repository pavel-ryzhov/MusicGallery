package com.example.musicgallery.models.remote.tracks

import com.google.gson.annotations.SerializedName


data class AlbumRemote (

    @SerializedName("artist") val artist : String,
    @SerializedName("mbid") val mbid : String,
    @SerializedName("tags") val tags : TagsRemote,
    @SerializedName("playcount") val playcount : Int,
    @SerializedName("image") val image : List<ImageRemote>,
    @SerializedName("tracks") val tracks : TracksRemote,
    @SerializedName("url") val url : String,
    @SerializedName("name") val name : String,
    @SerializedName("listeners") val listeners : Int,
    @SerializedName("wiki") val wiki : WikiRemote
)
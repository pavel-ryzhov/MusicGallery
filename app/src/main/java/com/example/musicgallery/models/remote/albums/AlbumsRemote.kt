package com.example.musicgallery.models.remote.albums

import com.google.gson.annotations.SerializedName

data class AlbumsRemote (
    @SerializedName("album") val album : List<AlbumRemote>,
    @SerializedName("@attr") val attr : AttrRemote
)
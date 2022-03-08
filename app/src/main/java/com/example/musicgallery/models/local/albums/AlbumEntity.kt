package com.example.musicgallery.models.local.albums

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

data class AlbumEntity (
    @Embedded
    val albumLocal: AlbumLocal,
    @Relation(
        parentColumn = "name",
        entityColumn = "album_name"
    )
    val artistLocal: ArtistLocal?,
    @Relation(
        parentColumn = "name",
        entityColumn = "album_name"
    )
    val attrLocal: AttrLocal?,
    @Relation(
        parentColumn = "name",
        entityColumn = "album_name"
    )
    val imageLocal: ImageLocal?
)
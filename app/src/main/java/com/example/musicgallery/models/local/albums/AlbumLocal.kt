package com.example.musicgallery.models.local.albums

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.musicgallery.models.remote.albums.AlbumRemote

@Entity
data class AlbumLocal (
    @PrimaryKey
    @ColumnInfo(name = "name") val name : String,
    @ColumnInfo(name = "tag") val tag: String,
    @ColumnInfo(name = "mbid") val mbid : String,
    @ColumnInfo(name = "url") val url : String,
){
    companion object{
        fun fromRemote(albumRemote: AlbumRemote, tag: String): AlbumLocal{
            return AlbumLocal(
                albumRemote.name,
                tag,
                albumRemote.mbid,
                albumRemote.url
            )
        }
    }
}
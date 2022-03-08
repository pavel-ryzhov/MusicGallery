package com.example.musicgallery.models.local.tracks

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.musicgallery.models.remote.tracks.TrackRemote

@Entity
data class TrackLocal (

    @PrimaryKey
    @ColumnInfo(name = "name") val name : String,
    @ColumnInfo(name = "album_name") val albumName: String,
    @ColumnInfo(name = "duration") val duration : Int,
    @ColumnInfo(name = "url") val url : String,
    @ColumnInfo(name = "artist") val artist: String,
    @ColumnInfo(name = "favourite") var favourite: Boolean
){
    companion object{
        fun fromRemote(trackRemote: TrackRemote, albumName: String, favourite: Boolean = false): TrackLocal{
            return TrackLocal(
                trackRemote.name,
                albumName,
                trackRemote.duration,
                trackRemote.url,
                trackRemote.artist.name ?: "",
                favourite
            )
        }
    }
}
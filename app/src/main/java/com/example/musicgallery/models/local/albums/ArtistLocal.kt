package com.example.musicgallery.models.local.albums

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.musicgallery.models.remote.albums.ArtistRemote

@Entity
data class ArtistLocal (
	@PrimaryKey
	@ColumnInfo(name = "album_name") val albumName: String,
	@ColumnInfo(name = "name") val name : String,
	@ColumnInfo(name = "mbid") val mbid : String,
	@ColumnInfo(name = "url") val url : String
){
	companion object{
		fun fromRemote(artistRemote: ArtistRemote, albumName: String): ArtistLocal {
			return ArtistLocal(albumName = albumName, name = artistRemote.name ?: "", mbid = artistRemote.mbid ?: "", url = artistRemote.url ?: "")
		}
	}
}
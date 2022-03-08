package com.example.musicgallery.models.local.albums

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.musicgallery.models.remote.albums.ImageRemote

@Entity
data class ImageLocal (
	@PrimaryKey
	@ColumnInfo(name = "album_name") val albumName: String,
	@ColumnInfo(name = "#text") val text : String,
	@ColumnInfo(name = "size") val size : String
){
	companion object{
		fun fromRemote(imageRemote: ImageRemote, albumName: String): ImageLocal{
			return ImageLocal(albumName, imageRemote.text ?: "", imageRemote.size ?: "")
		}
	}
}
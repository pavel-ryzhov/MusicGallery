package com.example.musicgallery.models.local.albums

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.musicgallery.models.remote.albums.AttrRemote

@Entity
data class AttrLocal (
	@PrimaryKey
	@ColumnInfo(name = "album_name") val albumName: String,
	@ColumnInfo(name = "tag") val tag : String,
	@ColumnInfo(name = "page") val page : Int,
	@ColumnInfo(name = "perPage") val perPage : Int,
	@ColumnInfo(name = "totalPages") val totalPages : Int,
	@ColumnInfo(name = "total") val total : Int
){
	companion object{
		fun fromRemote(attrRemote: AttrRemote, albumName: String): AttrLocal{
			return AttrLocal(
				albumName,
				attrRemote.tag ?: "",
				attrRemote.page,
				attrRemote.perPage,
				attrRemote.totalPages,
				attrRemote.total
			)
		}
	}
}
package com.example.musicgallery.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.musicgallery.models.local.albums.*

@Dao
interface AlbumDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllAlbums(albums: List<AlbumLocal>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllArtists(artists: List<ArtistLocal>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllImages(images: List<ImageLocal>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllAttrs(attrs: List<AttrLocal>)

    @Query("SELECT * FROM albumLocal WHERE tag = :tagName")
    fun getAll(tagName: String): LiveData<List<AlbumEntity>>
}
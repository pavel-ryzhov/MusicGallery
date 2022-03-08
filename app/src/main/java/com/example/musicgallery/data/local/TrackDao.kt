package com.example.musicgallery.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.musicgallery.models.local.tracks.*

@Dao
interface TrackDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTracks(tracks: List<TrackLocal>)

    @Query("SELECT * FROM trackLocal WHERE album_name = :album")
    fun getAll(album: String): LiveData<List<TrackLocal>>

    @Query("SELECT * FROM trackLocal WHERE favourite = 1")
    fun getFavourite(): LiveData<List<TrackLocal>>
}
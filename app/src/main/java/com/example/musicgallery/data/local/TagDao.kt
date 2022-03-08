package com.example.musicgallery.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.musicgallery.models.local.tags.TagLocal

@Dao
interface TagDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTags(tags: List<TagLocal>)

    @Query("SELECT * FROM tagLocal")
    fun getAll(): LiveData<List<TagLocal>>
}
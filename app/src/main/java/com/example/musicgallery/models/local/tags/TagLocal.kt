package com.example.musicgallery.models.local.tags

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.musicgallery.models.remote.tags.TagRemote

@Entity
data class TagLocal(
    @PrimaryKey
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "count") val count: Int,
    @ColumnInfo(name = "reach") val reach: Int
){
    companion object{
        fun fromRemote(tag: TagRemote): TagLocal{
            return TagLocal(
                tag.name,
                tag.count,
                tag.reach
            )
        }
    }
}
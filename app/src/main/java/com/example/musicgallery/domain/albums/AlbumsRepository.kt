package com.example.musicgallery.domain.albums

import androidx.lifecycle.LiveData
import com.example.musicgallery.models.local.albums.AlbumEntity

interface AlbumsRepository {
    suspend fun fetchAlbums(tag: String)
    fun subscribeOnAlbums(tag: String): LiveData<List<AlbumEntity>>
}
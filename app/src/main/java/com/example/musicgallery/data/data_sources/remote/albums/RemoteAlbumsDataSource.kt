package com.example.musicgallery.data.data_sources.remote.albums

import com.example.musicgallery.models.remote.albums.AlbumRemote

interface RemoteAlbumsDataSource {
    suspend fun getAlbums(tag: String): List<AlbumRemote>
}
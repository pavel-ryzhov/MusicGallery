package com.example.musicgallery.data.data_sources.local.albums

import androidx.lifecycle.LiveData
import com.example.musicgallery.models.local.albums.*

interface LocalAlbumsDataSource {
    fun subscribeOnAlbums(tag: String): LiveData<List<AlbumEntity>>

    suspend fun insertAllAlbumLocal(albums: List<AlbumLocal>)

    suspend fun insertAllArtistLocal(artist: List<ArtistLocal>)

    suspend fun insertAllImageLocal(images: List<ImageLocal>)

    suspend fun insertAllAttrLocal(attrs: List<AttrLocal>)
}
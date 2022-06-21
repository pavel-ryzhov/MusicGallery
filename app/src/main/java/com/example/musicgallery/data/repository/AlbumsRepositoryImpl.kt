package com.example.musicgallery.data.repository

import androidx.lifecycle.LiveData
import com.example.musicgallery.data.data_sources.local.albums.LocalAlbumsDataSource
import com.example.musicgallery.data.data_sources.remote.albums.RemoteAlbumsDataSource
import com.example.musicgallery.domain.albums.AlbumsRepository
import com.example.musicgallery.models.local.albums.*
import java.lang.Exception

import javax.inject.Inject

class AlbumsRepositoryImpl @Inject constructor(
    private val remoteAlbumsDataSource: RemoteAlbumsDataSource,
    private val localAlbumsDataSource: LocalAlbumsDataSource
) : AlbumsRepository {
    override suspend fun fetchAlbums(tag: String) {
        try {
            val albums = remoteAlbumsDataSource.getAlbums(tag)
            localAlbumsDataSource.insertAllAlbumLocal(albums.map { AlbumLocal.fromRemote(it, tag) })
            localAlbumsDataSource.insertAllArtistLocal(albums.map {
                ArtistLocal.fromRemote(
                    it.artist,
                    it.name
                )
            })
            localAlbumsDataSource.insertAllAttrLocal(albums.map {
                AttrLocal.fromRemote(
                    it.attr,
                    it.name
                )
            })
            localAlbumsDataSource.insertAllImageLocal(albums.map {
                ImageLocal.fromRemote(
                    it.image.last(),
                    it.name
                )
            })
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    override fun subscribeOnAlbums(tag: String): LiveData<List<AlbumEntity>> {
        return localAlbumsDataSource.subscribeOnAlbums(tag)
    }
}
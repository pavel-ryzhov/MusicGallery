package com.example.musicgallery.data.services

import com.example.musicgallery.BuildConfig
import com.example.musicgallery.models.remote.albums.AlbumsRemoteWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumsService {
    companion object{
        private const val BASE_PATH = "2.0"
        private const val METHOD = "tag.getTopAlbums"
        private const val API_KEY = BuildConfig.API_KEY
        private const val FORMAT = "json"
    }

    @GET(BASE_PATH)
    suspend fun getAlbums(
        @Query("method") method: String = METHOD,
        @Query("tag") tag: String,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = FORMAT,
    ): AlbumsRemoteWrapper
}
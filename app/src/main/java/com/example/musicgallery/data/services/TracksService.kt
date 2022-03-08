package com.example.musicgallery.data.services

import com.example.musicgallery.models.remote.tracks.TrackRemoteWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface TracksService {
    companion object{
        private const val BASE_PATH = "2.0"
        private const val METHOD = "album.getInfo"
        private const val API_KEY = "a35699f435445486aec22d7a19e652bf"
        private const val FORMAT = "json"
    }

    @GET(BASE_PATH)
    suspend fun getTracks(
        @Query("album") album: String,
        @Query("artist") artist: String,
        @Query("method") method: String = METHOD,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = FORMAT
    ): TrackRemoteWrapper
}
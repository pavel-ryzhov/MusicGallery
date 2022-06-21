package com.example.musicgallery.data.services

import com.example.musicgallery.BuildConfig
import com.example.musicgallery.models.remote.tags.TagsRemoteWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface TagsService {
    companion object{
        private const val BASE_PATH = "2.0"
        private const val METHOD = "tag.getTopTags"
        private const val API_KEY = BuildConfig.API_KEY
        private const val FORMAT = "json"
    }

    @GET(BASE_PATH)
    suspend fun getTags(
        @Query("method") method: String = METHOD,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("format") format: String = FORMAT,
    ): TagsRemoteWrapper
}
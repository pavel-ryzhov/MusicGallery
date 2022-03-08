package com.example.musicgallery.domain.tracks

import androidx.lifecycle.LiveData
import com.example.musicgallery.models.local.tracks.TrackLocal

interface TracksRepository {
    suspend fun fetchTracks(album: String, artist: String)
    fun subscribeOnTracks(album: String): LiveData<List<TrackLocal>>
    fun subscribeOnFavourite(): LiveData<List<TrackLocal>>
    suspend fun updateTracks(tracks: List<TrackLocal>)
}
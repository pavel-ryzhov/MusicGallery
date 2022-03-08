package com.example.musicgallery.data.data_sources.local.tracks

import androidx.lifecycle.LiveData
import com.example.musicgallery.models.local.tracks.TrackLocal

interface LocalTracksDataSource {
    fun subscribeOnTracks(album: String): LiveData<List<TrackLocal>>

    suspend fun insertAllTracks(tracks: List<TrackLocal>)

    fun subscribeOnFavourite(): LiveData<List<TrackLocal>>

}
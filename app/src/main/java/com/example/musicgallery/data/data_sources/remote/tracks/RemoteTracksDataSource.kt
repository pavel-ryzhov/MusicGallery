package com.example.musicgallery.data.data_sources.remote.tracks

import com.example.musicgallery.models.remote.tracks.TrackRemote

interface RemoteTracksDataSource {
    suspend fun getTracks(album: String, artist: String): List<TrackRemote>
}
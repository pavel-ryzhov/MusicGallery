package com.example.musicgallery.domain.tracks

import androidx.lifecycle.LiveData
import com.example.musicgallery.models.local.tracks.TrackLocal
import javax.inject.Inject

class TracksInteractorImpl @Inject constructor(private val tracksRepository: TracksRepository): TracksInteractor {
    override suspend fun fetchTracks(album: String, artist: String) = tracksRepository.fetchTracks(album, artist)

    override fun subscribeOnTracks(album: String): LiveData<List<TrackLocal>> = tracksRepository.subscribeOnTracks(album)

    override fun subscribeOnFavourite(): LiveData<List<TrackLocal>> = tracksRepository.subscribeOnFavourite()

    override suspend fun updateTracks(tracks: List<TrackLocal>) = tracksRepository.updateTracks(tracks)
}
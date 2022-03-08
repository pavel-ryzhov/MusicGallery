package com.example.musicgallery.presentation.tracks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicgallery.domain.tracks.TracksInteractor
import com.example.musicgallery.models.local.tracks.TrackLocal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TracksViewModel @Inject constructor(private val tracksInteractor: TracksInteractor): ViewModel() {

    fun fetchTracks(album: String, artist: String){
        viewModelScope.launch(Dispatchers.IO) {
            tracksInteractor.fetchTracks(album, artist)
        }
    }

    fun subscribeOnTracks(album: String) = tracksInteractor.subscribeOnTracks(album)

    fun subscribeOnFavourite() = tracksInteractor.subscribeOnFavourite()

    fun updateTracks(tracks: List<TrackLocal>){
        viewModelScope.launch(Dispatchers.IO) {
            tracksInteractor.updateTracks(tracks)
        }
    }
}
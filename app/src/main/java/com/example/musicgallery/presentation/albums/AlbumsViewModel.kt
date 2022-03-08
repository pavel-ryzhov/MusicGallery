package com.example.musicgallery.presentation.albums

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicgallery.domain.albums.AlbumsInteractor
import com.example.musicgallery.domain.login.LoginInteractor
import com.example.musicgallery.domain.tags.TagsInteractor
import com.example.musicgallery.models.local.albums.AlbumEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumsViewModel @Inject constructor(
    private val albumsInteractor: AlbumsInteractor
) : ViewModel() {

    fun fetchAlbums(tag: String) {
        viewModelScope.launch(Dispatchers.IO) {
            albumsInteractor.fetchAlbums(tag)
        }
    }

    fun subscribeOnAlbums(tag: String): LiveData<List<AlbumEntity>> = albumsInteractor.subscribeOnAlbums(tag)
}
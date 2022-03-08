package com.example.musicgallery.presentation.tags

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicgallery.domain.login.LoginInteractor
import com.example.musicgallery.domain.tags.TagsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TagsViewModel @Inject constructor(
    private val tagsInteractor: TagsInteractor,
    private val loginInteractor: LoginInteractor
    ): ViewModel() {

    val logoutLiveData = MutableLiveData<Unit>()
    val tagsLiveData = tagsInteractor.subscribeOnTags()

    fun fetchTags(){
        viewModelScope.launch(Dispatchers.IO) {
            tagsInteractor.fetchTags()
        }
    }

    fun logout() {
        viewModelScope.launch(Dispatchers.IO) {
            loginInteractor.logout()
            logoutLiveData.postValue(Unit)
        }
    }
}
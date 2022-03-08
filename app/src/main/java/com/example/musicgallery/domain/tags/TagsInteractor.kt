package com.example.musicgallery.domain.tags

import androidx.lifecycle.LiveData
import com.example.musicgallery.models.local.tags.TagLocal

interface TagsInteractor {
    suspend fun fetchTags()
    fun subscribeOnTags(): LiveData<List<TagLocal>>
}
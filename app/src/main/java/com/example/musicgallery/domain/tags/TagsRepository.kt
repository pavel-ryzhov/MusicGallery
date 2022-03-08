package com.example.musicgallery.domain.tags

import androidx.lifecycle.LiveData
import com.example.musicgallery.models.local.tags.TagLocal

interface TagsRepository {
    suspend fun fetchTags()
    fun subscribeOnTags(): LiveData<List<TagLocal>>
}
package com.example.musicgallery.data.data_sources.local.tags

import androidx.lifecycle.LiveData
import com.example.musicgallery.models.local.tags.TagLocal

interface LocalTagsDataSource {
    fun subscribeOnTags(): LiveData<List<TagLocal>>

    suspend fun insertAllTags(tags: List<TagLocal>)
}
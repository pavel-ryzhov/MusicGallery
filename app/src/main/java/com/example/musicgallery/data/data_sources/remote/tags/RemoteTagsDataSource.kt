package com.example.musicgallery.data.data_sources.remote.tags

import com.example.musicgallery.models.remote.tags.TagRemote

interface RemoteTagsDataSource {
    suspend fun getTags(): List<TagRemote>
}
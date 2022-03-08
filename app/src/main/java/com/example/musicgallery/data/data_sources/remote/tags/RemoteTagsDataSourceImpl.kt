package com.example.musicgallery.data.data_sources.remote.tags

import com.example.musicgallery.data.services.TagsService
import com.example.musicgallery.models.remote.tags.TagRemote
import javax.inject.Inject

class RemoteTagsDataSourceImpl @Inject constructor(private val tagsService: TagsService): RemoteTagsDataSource {
    override suspend fun getTags(): List<TagRemote> = tagsService.getTags().toptags.tag
}
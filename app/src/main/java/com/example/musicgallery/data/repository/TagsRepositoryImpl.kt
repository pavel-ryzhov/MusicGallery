package com.example.musicgallery.data.repository

import com.example.musicgallery.data.data_sources.local.tags.LocalTagsDataSource
import com.example.musicgallery.data.data_sources.remote.tags.RemoteTagsDataSource
import com.example.musicgallery.domain.tags.TagsRepository
import com.example.musicgallery.models.local.tags.TagLocal
import javax.inject.Inject

class TagsRepositoryImpl @Inject constructor(
    private val remoteTagsDataSource: RemoteTagsDataSource,
    private val localTagsDataSource: LocalTagsDataSource
): TagsRepository {
    override suspend fun fetchTags() {
        try {
            val tags = remoteTagsDataSource.getTags().map { TagLocal.fromRemote(it) }
            localTagsDataSource.insertAllTags(tags)
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    override fun subscribeOnTags() = localTagsDataSource.subscribeOnTags()
}
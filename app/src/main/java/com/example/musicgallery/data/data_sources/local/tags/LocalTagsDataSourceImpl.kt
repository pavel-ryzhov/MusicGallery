package com.example.musicgallery.data.data_sources.local.tags

import com.example.musicgallery.data.local.TagDao
import com.example.musicgallery.models.local.tags.TagLocal
import javax.inject.Inject

class LocalTagsDataSourceImpl @Inject constructor(private val tagDao: TagDao): LocalTagsDataSource {
    override fun subscribeOnTags() = tagDao.getAll()

    override suspend fun insertAllTags(tags: List<TagLocal>) = tagDao.insertAllTags(tags)
}
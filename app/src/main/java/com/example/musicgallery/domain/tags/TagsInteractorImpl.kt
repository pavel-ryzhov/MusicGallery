package com.example.musicgallery.domain.tags

import androidx.lifecycle.LiveData
import com.example.musicgallery.models.local.tags.TagLocal
import javax.inject.Inject

class TagsInteractorImpl @Inject constructor(private val tagsRepository: TagsRepository): TagsInteractor {
    override suspend fun fetchTags() = tagsRepository.fetchTags()

    override fun subscribeOnTags(): LiveData<List<TagLocal>> = tagsRepository.subscribeOnTags()
}
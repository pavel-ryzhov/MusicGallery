package com.example.musicgallery.domain.registration

import com.example.musicgallery.models.local.user.UserEntity

interface RegistrationInteractor {
    suspend fun saveUser(userEntity: UserEntity)
}
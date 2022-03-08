package com.example.musicgallery.domain.login

import com.example.musicgallery.models.local.user.UserEntity

interface LoginInteractor {
    suspend fun checkUser(userEntity: UserEntity): Boolean
    suspend fun checkAutoLogin(): Boolean
    suspend fun logout()
}
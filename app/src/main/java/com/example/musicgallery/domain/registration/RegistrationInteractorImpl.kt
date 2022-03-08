package com.example.musicgallery.domain.registration

import com.example.musicgallery.data.local.UserDao
import com.example.musicgallery.models.local.user.UserEntity
import javax.inject.Inject

class RegistrationInteractorImpl @Inject constructor(private val userDao: UserDao) : RegistrationInteractor {
    override suspend fun saveUser(userEntity: UserEntity){
        userDao.insert(userEntity)
    }
}
package com.example.musicgallery.domain.login

import com.example.musicgallery.data.local.UserDao
import com.example.musicgallery.models.local.user.UserEntity
import javax.inject.Inject

class LoginInteractorImpl @Inject constructor(private val userDao: UserDao) : LoginInteractor {

    override suspend fun checkUser(userEntity: UserEntity): Boolean {
        val users = userDao.getUsers()
        if (users.contains(userEntity)){
            return true
        }else if (users.contains(UserEntity(userEntity.name, userEntity.email, userEntity.password, !userEntity.saveCredentials))){
            userDao.insert(userEntity)
            return true
        }
        return false
    }

    override suspend fun checkAutoLogin(): Boolean {
        userDao.getUsers().forEach {
            if (it.saveCredentials) return true
        }
        return false
    }

    override suspend fun logout() {
        userDao.getUsers().forEach {
            if (it.saveCredentials){
                userDao.insert(UserEntity(it.name, it.email, it.password, false))
            }
        }
    }
}
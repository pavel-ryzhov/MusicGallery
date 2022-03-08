package com.example.musicgallery.presentation.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicgallery.domain.login.LoginInteractor
import com.example.musicgallery.models.local.user.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginInteractor: LoginInteractor) : ViewModel() {
    val loginLiveData = MutableLiveData<Boolean>()
    val autoLoginLiveData = MutableLiveData<Boolean>()

    fun checkUser(name: String, email: String, password: String, saveCredentials: Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            loginLiveData.postValue(loginInteractor.checkUser(UserEntity(name, email, password, saveCredentials)))
        }
    }
    fun checkAutoLogin() {
        viewModelScope.launch(Dispatchers.IO) {
            autoLoginLiveData.postValue(loginInteractor.checkAutoLogin())
        }
    }
}
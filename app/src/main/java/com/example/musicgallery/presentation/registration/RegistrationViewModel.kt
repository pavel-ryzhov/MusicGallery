package com.example.musicgallery.presentation.registration

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicgallery.data.local.extensions.isEmailValid
import com.example.musicgallery.data.local.extensions.isPasswordValid
import com.example.musicgallery.domain.registration.RegistrationInteractor
import com.example.musicgallery.models.local.user.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val registrationInteractor: RegistrationInteractor): ViewModel() {
    val registrationLiveData = MutableLiveData<Boolean>()
    fun saveUser(name: String, email: String, password: String, confirmPassword: String, saveCredentials: Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            if (name.isNotBlank() && email.isEmailValid() && password == confirmPassword && password.isPasswordValid()){
                registrationInteractor.saveUser(UserEntity(name, email, password, saveCredentials))
                registrationLiveData.postValue(true)
            }else{
                registrationLiveData.postValue(false)
            }
        }
    }
}
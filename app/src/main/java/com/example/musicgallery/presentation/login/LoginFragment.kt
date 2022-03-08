package com.example.musicgallery.presentation.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.musicgallery.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.textfield.TextInputEditText
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginViewModel.checkAutoLogin()

        val buttonSignUp = view.findViewById<MaterialButton>(R.id.button_sign_up)
        val buttonLogin = view.findViewById<MaterialButton>(R.id.button_login)

        val editTextName = view.findViewById<TextInputEditText>(R.id.edit_text_name)
        val editTextEmail = view.findViewById<TextInputEditText>(R.id.edit_text_email)
        val editTextPassword = view.findViewById<TextInputEditText>(R.id.edit_text_password)

        val checkboxSaveCredentials = view.findViewById<MaterialCheckBox>(R.id.checkbox_save_credentials)

        buttonSignUp.setOnClickListener {
            findNavController().navigate(R.id.registrationFragment)
        }
        buttonLogin.setOnClickListener {
            loginViewModel.checkUser(
                editTextName.text.toString(),
                editTextEmail.text.toString(),
                editTextPassword.text.toString(),
                checkboxSaveCredentials.isChecked
            )
        }

        subscribeOnLiveData()
    }

    private fun subscribeOnLiveData(){
        loginViewModel.loginLiveData.observe(viewLifecycleOwner){
            if (it){
                findNavController().navigate(R.id.tagsFragment)
            }else{
                Toast.makeText(requireContext(), "something is wrong", Toast.LENGTH_SHORT).show()
            }
        }
        loginViewModel.autoLoginLiveData.observe(viewLifecycleOwner){
            if (it) findNavController().navigate(R.id.tagsFragment)
        }
    }
}
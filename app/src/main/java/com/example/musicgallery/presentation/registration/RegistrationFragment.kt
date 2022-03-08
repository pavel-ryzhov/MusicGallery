package com.example.musicgallery.presentation.registration

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
class RegistrationFragment : Fragment() {

    private val registrationViewModel: RegistrationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonSignIn = view.findViewById<MaterialButton>(R.id.button_sign_in)
        val buttonRegister = view.findViewById<MaterialButton>(R.id.button_register)

        val editTextName = view.findViewById<TextInputEditText>(R.id.edit_text_name)
        val editTextEmail = view.findViewById<TextInputEditText>(R.id.edit_text_email)
        val editTextPassword = view.findViewById<TextInputEditText>(R.id.edit_text_password)
        val editTextConfirmPassword = view.findViewById<TextInputEditText>(R.id.edit_text_confirm_password)

        val checkboxSaveCredentials = view.findViewById<MaterialCheckBox>(R.id.checkbox_save_credentials)

        buttonSignIn.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }
        buttonRegister.setOnClickListener {
            registrationViewModel.saveUser(
                editTextName.text.toString(),
                editTextEmail.text.toString(),
                editTextPassword.text.toString(),
                editTextConfirmPassword.text.toString(),
                checkboxSaveCredentials.isChecked
            )
        }

        subscribeOnLiveData()
    }
    private fun subscribeOnLiveData(){
        registrationViewModel.registrationLiveData.observe(viewLifecycleOwner){
            if (it){
                findNavController().navigate(R.id.tagsFragment)
            }else{
                Toast.makeText(requireContext(), "something is wrong", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
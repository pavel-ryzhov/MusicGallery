package com.example.musicgallery.data.local.extensions

import androidx.core.util.PatternsCompat

fun String?.isEmailValid(): Boolean = this != null && isNotBlank() && PatternsCompat.EMAIL_ADDRESS.matcher(this).matches()

fun String?.isPasswordValid(): Boolean = this != null && isNotBlank() && this.length >= 5
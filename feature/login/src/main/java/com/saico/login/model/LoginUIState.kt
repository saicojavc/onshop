package com.saico.login.model

data class LoginUIState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null
)
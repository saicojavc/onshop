package com.saico.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saico.login.model.LoginUIState
import com.saico.onshop.model.sigin.SignInResult
import com.saico.onshop.ui.navigation.Navigator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val navigator: Navigator,
) : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUIState())
    val uiState = _uiState.asStateFlow()

//    fun onSignInResult(result: SignInResult){
//        _uiState.update {
//            it.copy(
//                isSignInSuccessful = result.data != null,
//                signInError = result.errorMessage
//            )
//        }
//    }
//
//    fun resetState() {
//        _uiState.update { LoginUIState() }
//    }
}
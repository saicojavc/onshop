package com.saico.onshop.activity

import androidx.lifecycle.ViewModel
import com.saico.login.model.LoginUIState
import com.saico.onshop.model.sigin.SignInResult
import com.saico.onshop.ui.navigation.NavigationCommand
import com.saico.onshop.ui.navigation.Navigator
import com.saico.onshop.ui.navigation.routes.home.HomeRoute
import com.saico.onshop.ui.navigation.routes.login.LoginRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
internal class MainActivityViewModel @Inject constructor(
    private val navigator: Navigator,
) : ViewModel() {
val firstScreen = LoginRoute.RootRoute.route
    private val _uiState = MutableStateFlow(LoginUIState())
    val uiState = _uiState.asStateFlow()

    fun onSignInResult(result: SignInResult){
        _uiState.update {
            it.copy(
                isSignInSuccessful = result.data != null,
                signInError = result.errorMessage
            )
        }

    }

    fun resetState() {
        _uiState.update { LoginUIState() }
    }
}
package com.saico.login

import androidx.lifecycle.ViewModel
import com.saico.onshop.ui.navigation.NavigationCommand
import com.saico.onshop.ui.navigation.Navigator
import com.saico.onshop.ui.navigation.routes.home.HomeRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LogInViewModel @Inject constructor(
    private val navigator: Navigator,
) : ViewModel(){

}
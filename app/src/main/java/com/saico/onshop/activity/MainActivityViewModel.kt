package com.saico.onshop.activity

import androidx.lifecycle.ViewModel
import com.saico.onshop.navigation.routes.login.LoginRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class MainActivityViewModel @Inject constructor(

) : ViewModel() {
val firstScreen = LoginRoute.RootRoute.route
}
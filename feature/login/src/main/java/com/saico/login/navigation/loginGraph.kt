package com.saico.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.saico.login.LoginScreen
import com.saico.onshop.ui.navigation.routes.login.LoginRoute

fun NavGraphBuilder.loginGraph(navHostController: NavHostController,  onLoginClick: () -> Unit) {
    navigation(
        startDestination = LoginRoute.LoginScreenRoute.route,
        route = LoginRoute.RootRoute.route
    ){
        composable(route = LoginRoute.LoginScreenRoute.route) {
            LoginScreen(
                navController = navHostController,
                onLoginClick = onLoginClick)
        }
    }
}
package com.saico.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.saico.login.LoginScreen
import com.saico.onshop.navigation.routes.login.LoginRoute

fun NavGraphBuilder.loginGraph(navHostController: NavHostController) {
    navigation(
        startDestination = LoginRoute.LoginScreenRoute.route,
        route = LoginRoute.RootRoute.route
    ){
        composable(route = LoginRoute.LoginScreenRoute.route) {
            LoginScreen(navHostController)
        }
    }
}
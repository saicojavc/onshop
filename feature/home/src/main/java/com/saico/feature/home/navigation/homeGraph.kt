package com.saico.feature.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.saico.feature.home.HomeScreen
import com.saico.onshop.ui.navigation.routes.home.HomeRoute

fun NavGraphBuilder.homeGraph(navHostController: NavHostController){
    navigation(
        startDestination = HomeRoute.HomeScreenRoute.route,
        route = HomeRoute.RootRoute.route
    ){
        composable(route = HomeRoute.HomeScreenRoute.route) {
            HomeScreen(navHostController)
        }
    }
}
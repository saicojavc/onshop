package com.saico.feature.product_detail.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.saico.feature.product_detail.ProductDetailScreen
import com.saico.onshop.ui.navigation.routes.product_detail.ProductDetailRoute

fun NavGraphBuilder.productDetailGraph(navHostController: NavHostController){
    navigation(
        startDestination = ProductDetailRoute.ProductDetailScreenRoute.route,
        route = ProductDetailRoute.RootRoute.route
    ){
        composable(route = ProductDetailRoute.ProductDetailScreenRoute.route){
            ProductDetailScreen()
        }
    }
}
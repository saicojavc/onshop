package com.saico.onshop.ui.navigation.routes.product_detail

import com.saico.onshop.ui.navigation.routes.Route

sealed interface ProductDetailRoute : Route {

    data object RootRoute : ProductDetailRoute {
        override val analyticsTag = "product-detail-flow"
        override val route = "product-detail"
    }

    data object ProductDetailScreenRoute : ProductDetailRoute{
        override val analyticsTag = "product-detail-screen-flow"
        override val route = "product-detail/product-detail-screen"
    }
}
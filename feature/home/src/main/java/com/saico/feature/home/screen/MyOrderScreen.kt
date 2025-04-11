package com.saico.feature.home.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.saico.feature.home.model.product.Product
import com.saico.onshop.ui.components.OSTopAppBar
import com.saico.onshop.ui.navigation.routes.product_detail.ProductDetailRoute
import com.saico.onshop.ui.theme.AppDim
import com.saico.onshop.ui.theme.PaddingDim

@Composable
fun MyOrderScreen(
    modifier: Modifier,
    navController: NavHostController,
){
   val product = Product()

    AllProductContent(
        items = product.manList,
        navController = navController
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllProductContent(
    items: List<Int>,
    navController: NavHostController,
    ) {

    Scaffold(
        topBar = {
            OSTopAppBar(
                title = {
                    Text("All Products")
                },
                modifier = Modifier
                    .fillMaxWidth(),
            )
        }
    ){ paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(count = 2),
            contentPadding = PaddingValues(PaddingDim.LARGE),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .padding(bottom = PaddingDim.EXTRA_HUGE)
        ) {
            items(items){ item ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(PaddingDim.SMALL),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ElevatedCard(
                        modifier = Modifier
                            .clickable {
                                navController.navigate(
                                    ProductDetailRoute.ProductDetailScreenRoute.route
                                )
                            },
                        shape = ShapeDefaults.Medium
                    ) {
                        Image(
                            painter = painterResource(id = item),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier

                                .size(AppDim.ROW_DATA_TIME_SIZE)
                                .clip(RoundedCornerShape(PaddingDim.LARGE))
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(PaddingDim.VERY_SMALL),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Product",
                            fontWeight = FontWeight.Bold,
                        )
                        Text(
                            text = "$200",
                            fontWeight = FontWeight.Bold,
                        )
                    }


                }
            }
        }
    }


}
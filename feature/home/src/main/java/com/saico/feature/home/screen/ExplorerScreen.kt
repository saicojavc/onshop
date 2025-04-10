package com.saico.feature.home.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.saico.feature.home.model.product.Product
import com.saico.onshop.ui.R
import com.saico.onshop.ui.components.OSCard
import com.saico.onshop.ui.components.OSIcon
import com.saico.onshop.ui.components.OSText
import com.saico.onshop.ui.components.icon.OSIcons
import com.saico.onshop.ui.navigation.routes.product_detail.ProductDetailRoute
import com.saico.onshop.ui.theme.AppDim
import com.saico.onshop.ui.theme.FontSizes
import com.saico.onshop.ui.theme.PaddingDim
import kotlinx.coroutines.delay

@Composable
fun ExplorerScreen(
    modifier: Modifier,
    navController: NavHostController,
) {

    val product = Product()

    Content(
        navController = navController,
        product = product
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content(
    navController: NavHostController,
    product: Product
    ) {

    val item = listOf(
        R.drawable.banner0,
        R.drawable.banner1,
        R.drawable.banner2,
    )
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = { item.size }
    )
    LaunchedEffect(Unit) {
        while (true) {
            delay(5000)
            pagerState.animateScrollToPage(
                (pagerState.currentPage + 1) % item.size,
            )
        }
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Home") }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                HorizontalPager(
                    state = pagerState,
                    beyondViewportPageCount = item.size,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(PaddingDim.VERY_SMALL),
                ) { itemIndex ->
                    Image(
                        painter = painterResource(id = item[itemIndex]),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(PaddingDim.SMALL)

                    )
                }
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = PaddingDim.SMALL),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OSText(
                        text = "Offiial Brand",
                        fontSize = FontSizes.TITLE,
                        fontWeight = FontWeight.Bold
                    )
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = PaddingDim.SMALL),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        items(product.brandList.zip(product.brandText)) { (image, name) ->
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.padding(PaddingDim.MEDIUM)
                            ) {
                                Image(
                                    modifier = Modifier
                                        .size(AppDim.IMAGES_HEIGHT)
                                        .padding(horizontal = PaddingDim.LARGE),
                                    painter = painterResource(id = image),
                                    contentDescription = name
                                )
                                OSText(text = name)
                            }
                        }
                    }

                }
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = PaddingDim.SMALL),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(PaddingDim.VERY_SMALL),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        OSText(
                            text = "Most Popular",
                            fontWeight = FontWeight.Bold
                        )
                        OSText(
                            text = "Show all",
                            fontWeight = FontWeight.Bold
                        )
                    }
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(PaddingDim.SMALL),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        items(product.manList) { item ->
                            Column {
                                OSCard(
                                    modifier = Modifier
                                        .padding(PaddingDim.VERY_SMALL)
                                        .clickable {
                                            navController.navigate(
                                                ProductDetailRoute.ProductDetailScreenRoute.route
                                            )
                                        },
                                    content = {
                                        Image(
                                            modifier = Modifier.size(AppDim.BAR_DIMEN),
                                            painter = painterResource(id = item),
                                            contentDescription = null
                                        )
                                    }
                                )
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Row(
                                        modifier = Modifier.padding(PaddingDim.MEDIUM),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        OSIcon(
                                            imageVector = OSIcons.Star,
                                            contentDescription = null,
                                            tint = Color(0xFFFFD700),
                                            background = Color.Unspecified
                                        )
                                        Text(text = "4.3")
                                    }
                                    Text(text = "$54")
                                }
                            }
                        }
                    }
                }
            }

        }
    }
}
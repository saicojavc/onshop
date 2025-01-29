package com.saico.feature.home.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.saico.onshop.ui.R
import com.saico.onshop.ui.components.OSText
import com.saico.onshop.ui.theme.AppDim
import com.saico.onshop.ui.theme.FontSizes
import com.saico.onshop.ui.theme.PaddingDim
import kotlinx.coroutines.delay

@Composable
fun ExplorerScreen(
    modifier: Modifier
){
   Content()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content(){


    val brandList = listOf(
        R.drawable.cat1,
        R.drawable.cat2,
        R.drawable.cat3,
        R.drawable.cat4,
        R.drawable.cat5,
        R.drawable.cat6,
    )
    val brandText = listOf(
        "Adidas", "Nike", "Puma", "ZARA", "Gucci", "Prada"
    )
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
                        .padding(PaddingDim.SMALL),
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
                        items(brandList.zip(brandText)) { (image, name) ->
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
                                OSText(text = name,)
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
             Text("palplaspdlasld")
                }
            }

        }
    }
}
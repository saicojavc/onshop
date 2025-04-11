package com.saico.feature.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.saico.feature.home.model.BottomAppBarItem
import com.saico.feature.home.screen.CartScreen
import com.saico.feature.home.screen.ExplorerScreen
import com.saico.feature.home.screen.FavoriteScreen
import com.saico.feature.home.screen.MyOrderScreen
import com.saico.feature.home.screen.ProfileScreen
import com.saico.onshop.ui.components.OShNavigationBar
import com.saico.onshop.ui.components.OShNavigationBarItem
import com.saico.onshop.ui.R
import com.saico.onshop.ui.components.OSText
import com.saico.onshop.ui.theme.PaddingDim

@Composable
fun HomeScreen(
    navController: NavHostController,
) {
   Content(navController = navController)
}

@Composable
fun Content( navController: NavHostController,){
    var selectedBottomAppBarItem by remember { mutableStateOf(BottomAppBarItem.EXPLORER) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            OShNavigationBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(PaddingDim.VERY_SMALL)
                    .clip(
                        shape = CircleShape
                    ),
                contentColor = Color.Black,
                containerColor = Color.Black,
                tonalElevation = 0.dp,
                content = {
                    OShNavigationBarItem(
                        isSelected = selectedBottomAppBarItem == BottomAppBarItem.FAVORITE,
                        onClick = { selectedBottomAppBarItem = BottomAppBarItem.FAVORITE },
                        icon = painterResource(id = R.drawable.btn_3),
                        label = {
                            OSText(
                                text = "Favorite",
                                color = Color.White
                            )
                        },
                        contentDescription = "Favorite"
                    )
                    OShNavigationBarItem(
                        isSelected = selectedBottomAppBarItem == BottomAppBarItem.CART,
                        onClick = { selectedBottomAppBarItem = BottomAppBarItem.CART },
                        icon = painterResource(id = R.drawable.btn_2),
                        label = {
                            OSText(
                                text = "Cart",
                                color = Color.White
                            )
                        },
                        contentDescription = "Cart"
                    )
                    OShNavigationBarItem(
                        isSelected = selectedBottomAppBarItem == BottomAppBarItem.EXPLORER,
                        onClick = { selectedBottomAppBarItem = BottomAppBarItem.EXPLORER },
                        icon = painterResource(id = R.drawable.btn_1),
                        label = {
                            OSText(
                                text = stringResource(id = R.string.explore),
                                color = Color.White
                            )
                        },
                        contentDescription = "Explorer"
                    )
                    OShNavigationBarItem(
                        isSelected = selectedBottomAppBarItem == BottomAppBarItem.MYORDER,
                        onClick = { selectedBottomAppBarItem = BottomAppBarItem.MYORDER },
                        icon = painterResource(id = R.drawable.btn_4),
                        label = {
                            OSText(
                                text = stringResource(id = R.string.myorder),
                                color = Color.White
                            )
                        },
                        contentDescription = "My order"
                    )
                    OShNavigationBarItem(
                        isSelected = selectedBottomAppBarItem == BottomAppBarItem.PROFILE,
                        onClick = { selectedBottomAppBarItem = BottomAppBarItem.PROFILE },
                        icon = painterResource(id = R.drawable.btn_5),
                        label = {
                            OSText(
                                text = stringResource(id = R.string.profile),
                                color = Color.White
                            )
                        },
                        contentDescription = "Profile"
                    )
                }
            )
        }
    ) { paddingValues ->

        Row {
            when(selectedBottomAppBarItem){
                BottomAppBarItem.EXPLORER -> {
                    ExplorerScreen(
                        modifier = Modifier.padding(paddingValues),
                        navController = navController
                    )
                }
                BottomAppBarItem.CART -> {
                    CartScreen(
                        modifier = Modifier.padding(paddingValues)
                    )
                }
                BottomAppBarItem.FAVORITE -> {
                    FavoriteScreen(
                        modifier = Modifier.padding(paddingValues)
                    )
                }
                BottomAppBarItem.MYORDER -> {
                    MyOrderScreen(
                        modifier = Modifier.padding(paddingValues),
                        navController = navController
                    )
                }
                BottomAppBarItem.PROFILE -> {
                   ProfileScreen(
                       modifier = Modifier.padding(paddingValues)
                   )
                }
            }
        }
    }
}
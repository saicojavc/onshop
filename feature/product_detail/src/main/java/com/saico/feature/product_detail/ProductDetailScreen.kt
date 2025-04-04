package com.saico.feature.product_detail

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.saico.onshop.ui.R
import com.saico.onshop.ui.components.OSCard
import com.saico.onshop.ui.components.OSDropDownMenu
import com.saico.onshop.ui.components.OSText
import com.saico.onshop.ui.components.OSTooltipIcon
import com.saico.onshop.ui.components.OSTooltipIconButton
import com.saico.onshop.ui.components.OSTopAppBar
import com.saico.onshop.ui.components.icon.OSIcons
import com.saico.onshop.ui.theme.AppDim
import com.saico.onshop.ui.theme.CornerDim
import com.saico.onshop.ui.theme.FontSizes
import com.saico.onshop.ui.theme.PaddingDim
import kotlinx.coroutines.delay

@Composable
fun ProductDetailScreen(
//    navController: NavHostController,
) {

    val viewModel : ProductDetailVM = hiltViewModel()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    val product = listOf(
        R.drawable.men1_1,
        R.drawable.men1_2,
        R.drawable.men1_3,
        R.drawable.men1_4,
        R.drawable.men1_5,
    )

//    LaunchedEffect(key1 = Unit) {
//        viewModel.fetchProductCount()
//    }

    Content(
        productImg = product,
        productCount = uiState.value.productCount,
//        addProductToCart = viewModel::addProductToCart
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content(
    productImg : List<Int>,
    productCount : Int,
//    addProductToCart: (id: String, productImg: Int, productName: String, productPrice: String, productQuantity: Int) -> Unit,
){
    val (expanded, onExpand) = remember { mutableStateOf(false) }
    var selectedImage by remember {
        mutableStateOf(productImg.firstOrNull())
    }
    var quantityModelIndex by remember { mutableStateOf(1) }
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = { productImg.size }
    )
    LaunchedEffect(Unit) {
        while (true) {
            delay(5000)
            pagerState.animateScrollToPage((pagerState.currentPage + 1) % productImg.size)
        }
    }
    //cambiar por los datos reales
    val models = listOf("core i3", "core i5", "core i7", "core i9")
    val quantity = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val quantityM = StringBuilder()
    quantityM.append(" ")
    quantityM.append(stringResource(R.string.quantity))
    quantityM.append(": ")
    quantityM.append(quantityModelIndex)

    Scaffold(
        topBar = {
            OSTopAppBar(
                title = {
                    Text("Product Detail")
                },
                actions = {
                    Box (
                        modifier = Modifier
                            .padding(PaddingDim.MEDIUM)
                    ){
                        if (productCount > 0){
                            Badge(
                                modifier = Modifier
                                    .padding(start = PaddingDim.MEDIUM)
                                    .align(Alignment.TopEnd)
                            ){
                                OSText(
                                    text = productCount.toString(),
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            }
                        }
                        OSTooltipIcon(
                            onClick = {
                                //navigation to cart
                            },
                            contentDescription = "Shopping Cart",
                            tooltipMsg = "ShoppingC art",
                            icon = OSIcons.ShoppingCart
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ) {
            item {
                selectedImage?.let { painterResource(id = it) }?.let {
                    Image(
                        painter = it,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(PaddingDim.SMALL)
                            .height(AppDim.LAYOUT_DIMEN)
                            .fillMaxWidth()
                            .clip(MaterialTheme.shapes.medium)
                            .background(MaterialTheme.colorScheme.surfaceVariant),
                    )
                }
                LazyRow(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(vertical = PaddingDim.MEDIUM)
                        .fillMaxWidth()
                ) {
                    items(productImg) {image ->
                        ImageRow(
                          image = image,
                            isSelected = (image == selectedImage),
                            onClick = {
                                selectedImage = image
                            }
                        )
                    }
                }
            }
            item {
                InformationBar()
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = PaddingDim.VERY_LARGE,
                            vertical = PaddingDim.SMALL
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    OSDropDownMenu(
                      modifier = Modifier
                          .fillMaxWidth()
                          .padding(PaddingDim.SMALL)
                          .height(AppDim.LOGIN_MEDIA_ICON_SIZE)
                          .border(
                              1.dp,
                              Color.Black,
                              RoundedCornerShape(PaddingDim.SMALL)
                          ),
                        selectedItem = quantityM.toString(),
                        items = quantity.map { it.toString() },
                        onSelect = { quantityModelIndex = it.toInt()}
                    )
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(PaddingDim.SMALL)
                            .height(AppDim.LOGIN_MEDIA_ICON_SIZE),
                        onClick = {
//                            addProductToCart(
//                                "1",
//                                productImg.first(),
//                                "Product Name", //cambiar
//                                "200", //cambiar
//                                quantity[quantityModelIndex - 1]
//                            )
                        },
                        shape = RoundedCornerShape(PaddingDim.VERY_LARGE),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onPrimaryContainer)
                    ) {
                        Text(
                            text = "Add to Cart"
                        )
                    }
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(PaddingDim.SMALL)
                            .height(AppDim.LOGIN_MEDIA_ICON_SIZE),
                        onClick = {},
                        shape = RoundedCornerShape(PaddingDim.VERY_LARGE),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                    ) {
                        Text(
                            text = "Buy Now"
                        )
                    }
                }
            }
            item {
                OSCard(
                    modifier = Modifier
                        .padding(PaddingDim.SMALL)
                        .clickable { onExpand(!expanded) }
                ) {
                    OSText(
                        text = "Lorem ipsum odor amet, consectetuer adipiscing elit. Eget maximus est leo per ornare ac ad. Luctus parturient eu ad duis; habitant aptent. Lectus mauris fringilla maecenas augue litora. Posuere mauris donec, posuere tortor dictumst suspendisse porta nascetur. Bibendum platea auctor magna volutpat eu placerat purus. Senectus dapibus hac a pellentesque torquent laoreet cursus est. Montes ex ac elit ultricies imperdiet phasellus, potenti ridiculus. Nascetur aliquam sociosqu justo porta dictum rhoncus. Felis eros accumsan ornare, vulputate senectus sociosqu. Nec justo proin diam suscipit; phasellus porta hendrerit facilisi. Eleifend justo feugiat a mi natoque condimentum.",
                        maxLines = if (expanded) Int.MAX_VALUE else 5,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .padding(PaddingDim.SMALL)
                            .animateContentSize(
                                spring(
                                    Spring.DampingRatioLowBouncy, Spring.StiffnessLow
                                )
                            )

                    )
                }
            }
            item {
                HorizontalPager(
                    state = pagerState,
                    beyondViewportPageCount = productImg.size,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            top = PaddingDim.MEDIUM,
                            bottom = PaddingDim.VERY_LARGE
                        )
                ) { page ->
                    Image(
                        painter = painterResource(id = productImg[page]),
                        contentDescription = null,
                        modifier =  Modifier
                            .padding(PaddingDim.SMALL)
                            .height(AppDim.LAYOUT_DIMEN)
                            .fillMaxWidth()
                            .clip(MaterialTheme.shapes.medium)
                            .background(MaterialTheme.colorScheme.surfaceVariant),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}

@Composable
fun ImageRow(
    image: Int,
    isSelected: Boolean,
    onClick: () -> Unit
){
    Box(
        modifier = Modifier
            .padding(PaddingDim.SMALL)
            .size(AppDim.LOGIN_MEDIA_ICON_SIZE)
            .clickable(onClick = onClick)
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .height(AppDim.LAYOUT_DIMEN)
                .fillMaxWidth()
                .clip(MaterialTheme.shapes.medium)
                .background(MaterialTheme.colorScheme.surfaceVariant),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun InformationBar(){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(PaddingDim.MEDIUM),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = PaddingDim.MEDIUM)
        ) {
            OSText(
                text = "Product Name",
                fontWeight = FontWeight.Bold,
                fontSize = FontSizes.TITLE
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                OSText(
                    text = "200",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = FontSizes.TITLE
                )
                Icon(
                    imageVector = OSIcons.AttachMoney,
                    contentDescription = null
                )
            }
        }
    }


}
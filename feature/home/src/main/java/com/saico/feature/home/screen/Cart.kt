package com.saico.feature.home.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.saico.onshop.ui.components.OSText
import com.saico.onshop.ui.components.OSTopAppBar
import com.saico.onshop.ui.theme.FontSizes
import com.saico.onshop.ui.theme.PaddingDim

@Composable
fun CartScreen(
    modifier: Modifier
) {
    Content()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content() {
    Scaffold(
topBar = {
    OSTopAppBar(
        title = {
            Text("Shopping Cart")
        },
        modifier = Modifier
            .fillMaxWidth()
    )
}
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ) {
            CartList()
        }
    }
}

@Composable
fun CartList() {
    LazyColumn(
        modifier = Modifier.padding(PaddingDim.MEDIUM)
    ) {
        val cartItems = listOf(
            com.saico.onshop.ui.R.drawable.men1_1,
            com.saico.onshop.ui.R.drawable.men2,
        )
        items(cartItems) { item ->
            CartItem(
                item = item
            )
        }
        item {
            CartSummary()
        }
        item {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(PaddingDim.SMALL)
                    .height(PaddingDim.VERY_HUGE),
                onClick = {},
                shape = RoundedCornerShape(PaddingDim.VERY_LARGE),
                colors = ButtonDefaults.buttonColors(contentColor = MaterialTheme.colorScheme.primary)
            ) {
                OSText(
                    text = "Buy Now",
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun CartItem(item: Int) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = PaddingDim.SMALL)
    ) {
        val (pic, titleText, feeEachTime, totalEachItem, quantity, deleteBtn) = createRefs()

        Image(
            painter = painterResource(id = item),
            contentDescription = null,
            modifier = Modifier
                .size(90.dp)
                .clip(shape = RoundedCornerShape(PaddingDim.MEDIUM))
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .constrainAs(pic) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
            contentScale = ContentScale.Crop
        )
        OSText(
            text = "Product Name",
            modifier = Modifier
                .constrainAs(titleText) {
                    start.linkTo(pic.end)
                    top.linkTo(pic.top)
                }
                .padding(
                    start = PaddingDim.SMALL,
                    top = PaddingDim.SMALL
                )
        )
        OSText(
            text = "$200",
            modifier = Modifier
                .constrainAs(feeEachTime) {
                    start.linkTo(titleText.start)
                    top.linkTo(titleText.bottom)
                }
                .padding(
                    start = PaddingDim.SMALL,
                    top = PaddingDim.SMALL
                ),
            color = MaterialTheme.colorScheme.primary
        )
        OSText(
            text = "$200",
            modifier = Modifier
                .constrainAs(totalEachItem){
                    start.linkTo(titleText.start)
                    bottom.linkTo(pic.bottom)
                }
                .padding(
                    start = PaddingDim.SMALL,
                    top = PaddingDim.SMALL
                ),
            fontSize = FontSizes.TITLE,
            fontWeight = FontWeight.Bold
        )

        IconButton(
            modifier = Modifier
                .padding(PaddingDim.SMALL)
                .constrainAs(deleteBtn){
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                },
            onClick = {},
            content = {
                Icon(
                    imageVector = Icons.Outlined.Delete,
                    contentDescription = null
                )
            }
        )
        ConstraintLayout(
            modifier = Modifier
                .padding(horizontal = PaddingDim.SMALL)
                .width(100.dp)
                .background(
                    MaterialTheme.colorScheme.surfaceVariant,
                    shape = RoundedCornerShape(18.dp)
                )
                .constrainAs(quantity){
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }
                .clip(shape = RoundedCornerShape(PaddingDim.MEDIUM))
        ) {

            val(plusCartBtn, minusCartBtn, numberItemText) = createRefs()

            OSText(
                text = "1",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .constrainAs(numberItemText){
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
            )
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .size(28.dp)
                    .background(
                        MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(18.dp)
                    )
                    .clickable {  }
                    .constrainAs(plusCartBtn){
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
            ){
                OSText(
                    text = "+",
                    color = Color.White,
                    modifier = Modifier.align(Alignment.Center),
                    textAlign =  TextAlign.Center
                )
            }
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .size(28.dp)
                    .background(
                        Color.White,
                        shape = RoundedCornerShape(18.dp)
                    )
                    .constrainAs(minusCartBtn){
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                    .clickable {

                    }
            ) {
                Text(
                    text = "-",
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.Center),
                    textAlign =  TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun CartSummary(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(PaddingDim.MEDIUM)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = PaddingDim.MEDIUM)
        ) {
            Text(
                text = "Total products: ",
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
            Text(
                text ="$400"
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = PaddingDim.MEDIUM)
        ) {
            Text(
                text = "Comision: ",
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
            Text(
                text = "$0.00"
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = PaddingDim.MEDIUM)
        ) {
            Text(
                text = "Delivery: ",
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
            Text(
                text = "$100.00"
            )
        }
        HorizontalDivider(
            modifier = Modifier.height(1.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = PaddingDim.MEDIUM)
        ) {
            Text(
                text = "Total: ",
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "$500",
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

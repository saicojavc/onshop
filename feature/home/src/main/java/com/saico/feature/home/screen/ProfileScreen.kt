package com.saico.feature.home.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.saico.feature.home.model.BodyItem
import com.saico.onshop.ui.components.OSTopAppBar
import com.saico.onshop.ui.theme.AppDim
import com.saico.onshop.ui.R
import com.saico.onshop.ui.components.OSIcon
import com.saico.onshop.ui.components.OSText
import com.saico.onshop.ui.components.icon.OSIcons
import com.saico.onshop.ui.theme.FontSizes
import com.saico.onshop.ui.theme.PaddingDim

@Composable
fun ProfileScreen(
    modifier: Modifier
){
    ProfileContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileContent(){
    val surfaceContainerLow = MaterialTheme.colorScheme.surfaceContainerLow
    Scaffold(
        topBar = {
                ConstraintLayout(
                    modifier = Modifier
                        .height(AppDim.ROW_DATA_TIME_SIZE)
                        .background(color = Color.Black)
                ) {
                    val (arco, topImg, title) = createRefs()

                    Canvas(
                        modifier = Modifier
                            .fillMaxWidth()
                            .constrainAs(arco) {
                                bottom.linkTo(parent.bottom)
                            }
                            .height(100.dp)
                    ) {
                        drawArc(
                            color = surfaceContainerLow,
                            startAngle = 180f,
                            sweepAngle = 180f,
                            useCenter = true,
                            topLeft = Offset(0f, size.height/2),
                            size = Size(size.width, size.height)

                        )
                    }
                    Image(
                        painter = painterResource(id = R.drawable.base_ic_user_male),
                        contentDescription = null,
                        modifier = Modifier
                            .size(AppDim.IMAGES_WIDTH)
                            .clip(CircleShape)
                            .fillMaxWidth()
                            .constrainAs(topImg) {
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                                bottom.linkTo(parent.bottom)
                            }
                    )
                    OSText(
                        text = "Name",
                        style = TextStyle(Color.White, fontSize = 30.sp),
                        modifier = Modifier
                            .constrainAs(title) {
                                top.linkTo(parent.top, margin = PaddingDim.VERY_LARGE)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }
                    )
                }

        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp)

        ) {
            Header()
            HorizontalDivider(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 4.dp)
                    .height(4.dp)
            )
            Body()
        }
    }
}

@Composable
fun Header(
) {
    val primary = MaterialTheme.colorScheme.primary
    Row(
        Modifier
            .fillMaxWidth()
            .padding(top = PaddingDim.LARGE),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Column {
            Text(
                text =  "full name",
                fontSize = FontSizes.TITLE_BIG,
                fontWeight = FontWeight.Bold,
                color = primary
            )
            Text(
                text =  "email@gmail.com",
                fontWeight = FontWeight.Bold,
                color = primary
            )
            Text(
                text = "3545678765",
                fontWeight = FontWeight.Bold,
                color = primary
            )
        }
    }
}

@Composable
fun Body(

) {

    val bodyItems = listOf(
        BodyItem(
            icon = OSIcons.SettingIcon,
            tittle = stringResource(id = R.string.settings),
            route = "SettingRoute.RootRoute.route"
        ),
        BodyItem(
            icon = OSIcons.PermissionIcon,
            tittle = stringResource(R.string.permission),
            route = "PermissionRoute.RootRoute.route"
        ),
        BodyItem(
            icon = OSIcons.NotificationIcon,
            tittle = stringResource(id = R.string.notification),
            route = "NotificationRoute.RootRoute.route"
        ),
        BodyItem(
            icon = OSIcons.InfoIcon,
            tittle = stringResource(R.string.about),
            route = "AboutRoute.RootRoute.route"
        ),
    )

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = WindowInsets.safeDrawing.asPaddingValues()
    ) {
        itemsIndexed(bodyItems) { _, it ->
            Row(
                modifier = Modifier
                    .clickable {  }
                    .padding(PaddingDim.MEDIUM),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                OSIcon(
                    imageVector = it.icon,
                    background = Color.Transparent,
                    modifier = Modifier.weight(0.15f)
                )
                OSText(
                    text = it.tittle,
                    fontSize = FontSizes.TITLE,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.weight(1f)
                )
                OSIcon(
                    imageVector = OSIcons.ArrowNext,
                    background = Color.Transparent,
                    modifier = Modifier.weight(0.15f)
                )
            }
        }
    }

}

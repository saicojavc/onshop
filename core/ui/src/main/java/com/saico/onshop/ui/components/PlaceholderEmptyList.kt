package com.saico.onshop.ui.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.saico.onshop.ui.R
import com.saico.onshop.ui.theme.AppDim
import com.saico.onshop.ui.theme.PaddingDim


/**
 * Creates a UI component for displaying an empty list view with a customizable message and image.
 *
 * @param modifier optional modifier that can be used to adjust the layout of the component
 * @param image optional resource identifier for the image to display alongside the empty message
 * @param title optional string resource identifier for the main message to display
 * @param subtitle optional string resource identifier for a secondary message to display
 */
@Composable
fun PlaceholderEmptyList(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int = R.drawable.base_ic_search_empty_folder,
    @StringRes title: Int = R.string.default_empty_title,
    @StringRes subtitle: Int = R.string.default_empty_subtitle,
) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SpacerHeight(94.dp)
            Image(
                painter = painterResource(id = image),
                contentDescription = stringResource(id = subtitle),
                modifier = Modifier.size(AppDim.IMAGES_SIZE),
                alpha = 0.4f
            )
            SpacerHeight(PaddingDim.SMALL)
            Text(
                text = stringResource(id = title),
                style = MaterialTheme.typography.titleLarge
            )
            SpacerHeight(PaddingDim.VERY_SMALL)
            Text(
                text = stringResource(id = subtitle),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}


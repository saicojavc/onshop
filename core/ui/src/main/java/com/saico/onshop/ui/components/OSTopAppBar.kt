package com.saico.onshop.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.saico.onshop.ui.theme.OSTopAppColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OSTopAppBar(
    modifier: Modifier,
    titleLabel: String = "",
    title: @Composable (() -> Unit) = { Text(text = titleLabel) },
    onClickNavigationIcon: () -> Unit = {},
    navigationIcon: @Composable (() -> Unit) = {
//        OSTooltipIconButton(
//            onClick = onClickNavigationIcon,
//            icon = OSIcons.OnBackIcon,
//            contentDescription = "Back",
//        )
    },
    colors: TopAppBarColors = OSTopAppColors,
    actions: @Composable (RowScope.() -> Unit) = {},
) {
    TopAppBar(
        title = title,
        modifier = modifier,
        navigationIcon = navigationIcon,
        colors = colors,
        actions = actions
    )
}

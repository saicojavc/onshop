package com.saico.onshop.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.saico.onshop.ui.theme.ElevationDim

@Composable
fun OSCard(
    modifier: Modifier = Modifier,
    shape: Shape = ShapeDefaults.Medium,
    elevation: Dp = ElevationDim.MEDIUM,
    content: @Composable () -> Unit,
) {
    Surface(
        modifier = modifier,
        shape = shape,
        border = null,
        contentColor = MaterialTheme.colorScheme.onSurface,
        tonalElevation = 0.dp,
        shadowElevation = elevation,
        content = {
            Column(modifier = Modifier.fillMaxWidth()) {
                content()
            }
        },
    )
}

@Composable
fun OSElevatedCard(
    modifier: Modifier = Modifier,
    shape: Shape = ShapeDefaults.Medium,
    elevation: Dp = ElevationDim.MEDIUM,
    border: BorderStroke? = null,
    content: @Composable (ColumnScope.() -> Unit),
) {
    Surface(
        modifier = modifier,
        shape = shape,
        border = border,
        contentColor = MaterialTheme.colorScheme.onSurface,
        tonalElevation = 0.dp,
        shadowElevation = elevation,
        content = {
            Column(modifier = Modifier.fillMaxWidth()) {
                content()
            }
        },
    )
}

@Composable
fun OSBoxElevatedCard(
    modifier: Modifier = Modifier,
    shape: Shape = ShapeDefaults.Medium,
    elevation: Dp = ElevationDim.MEDIUM,
    border: BorderStroke? = null,
    content: @Composable (BoxScope.() -> Unit),
) {
    Surface(
        modifier = modifier,
        shape = shape,
        border = border,
        contentColor = MaterialTheme.colorScheme.onSurface,
        tonalElevation = 0.dp,
        shadowElevation = elevation,
        content = {
            Box(modifier = Modifier.fillMaxWidth()) {
                content()
            }
        },
    )
}

@Composable
fun OSElevatedCardLongClick(
    modifier: Modifier = Modifier,
    shape: Shape = ShapeDefaults.Medium,
    elevation: Dp = ElevationDim.MEDIUM,
    content: @Composable (ColumnScope.() -> Unit),
) {
    Surface(
        modifier = modifier,
        shape = shape,
        border = null,
        contentColor = MaterialTheme.colorScheme.onSurface,
        tonalElevation = 0.dp,
        shadowElevation = elevation,
        content = {
            Column(modifier = Modifier.fillMaxWidth()) {
                content()
            }
        },
    )
}

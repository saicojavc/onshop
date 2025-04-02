package com.saico.onshop.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults
import androidx.compose.material3.rememberTooltipState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import com.saico.onshop.ui.theme.PaddingDim
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OSTooltipIcon(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    icon: ImageVector,
    contentDescription: String,
    tooltipMsg: String? = contentDescription,
    showTooltip: Boolean = false,
    initialIsVisible: Boolean = false,
    isPersistent: Boolean = false,
) {
    var allowClick by remember { mutableStateOf(true) }
    val state = rememberTooltipState(initialIsVisible = initialIsVisible, isPersistent = isPersistent)

    LaunchedEffect(showTooltip) {
        if (showTooltip) {
            state.show()
        }
    }

    TooltipBox(
        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
        tooltip = {
            tooltipMsg?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .padding(PaddingDim.SMALL)
                )
            }
        },
        modifier = modifier,
        state = state
    ) {
        IconButton(onClick = {
            if (allowClick) {
                onClick()
                allowClick = false
                state.dismiss()
            }
        }) { Icon(imageVector = icon, contentDescription = contentDescription) }
    }

    LaunchedEffect(key1 = allowClick) {
        if (!allowClick) {
            delay(1000)  // Espera 1 segundo antes de permitir otro clic
            allowClick = true
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OSTooltipPainter(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    painter: Painter,
    tint: Color,
    contentDescription: String,
    tooltipMsg: String? = contentDescription,
    isPersistent: Boolean = false,
) {
    var allowClick by remember { mutableStateOf(true) }

    TooltipBox(
        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
        tooltip = {
            tooltipMsg?.let {
                Text(
                    text = it,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .padding(PaddingDim.SMALL)
                )
            }
        },
        modifier = modifier,
        state = rememberTooltipState(isPersistent = isPersistent)
    ) {
        IconButton(onClick = {
            if (allowClick) {
                onClick()
                allowClick = false
            }
        }) { Icon(painter = painter, contentDescription = contentDescription, tint = tint) }
    }

    LaunchedEffect(key1 = allowClick) {
        delay(1000)
        if (!allowClick) {
            allowClick = true
        }
    }
}

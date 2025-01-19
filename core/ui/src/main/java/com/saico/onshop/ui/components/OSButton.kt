package com.saico.onshop.ui.components

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import com.saico.onshop.ui.theme.PaddingDim
import kotlinx.coroutines.delay

@Composable
fun OSButton(
    modifier: Modifier = Modifier,
    label: String = "",
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.textShape,
    content: @Composable RowScope.() -> Unit = { Text(text = label) },
    onClick: () -> Unit,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        content = content,
        shape = shape,
        colors = colors
    )
}

@Composable
fun OSTextButton(
    modifier: Modifier = Modifier,
    textButtonStyle: TextButtonStyle = TextButtonStyle.DEFAULT,
    label: String = "",
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit = { Text(text = label) },
    onClick: () -> Unit,
) {
    val textColor = when (textButtonStyle) {
        TextButtonStyle.DEFAULT -> MaterialTheme.colorScheme.primary
        TextButtonStyle.DISMISS -> MaterialTheme.colorScheme.error
    }

    TextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.textButtonColors(
            contentColor = textColor
        ),
        content = content
    )
}

@Composable
fun OSTextButtonBorder(
    modifier: Modifier = Modifier,
    textButtonStyle: TextButtonStyle = TextButtonStyle.DEFAULT,
    label: String = "",
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit = { Text(text = label) },
    contentPadding: PaddingValues = ButtonDefaults.TextButtonContentPadding,
    onClick: () -> Unit,
    border: BorderStroke = BorderStroke(
        PaddingDim.SUPER_SMALL,
        MaterialTheme.colorScheme.outline
    )
) {
    val textColor = when (textButtonStyle) {
        TextButtonStyle.DEFAULT -> MaterialTheme.colorScheme.primary
        TextButtonStyle.DISMISS -> MaterialTheme.colorScheme.error
    }

    TextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        border = border,
        colors = ButtonDefaults.textButtonColors(
            contentColor = textColor
        ),
        contentPadding = contentPadding,
        content = content
    )
}

enum class TextButtonStyle {
    DEFAULT, DISMISS
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OSTooltipIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    icon: ImageVector,
    contentDescription: String,
    tooltipMsg: String? = contentDescription,
    isPersistent: Boolean = false,
    tintColor: Color = Color.Unspecified,
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
        }) { Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = tintColor
        ) }
    }

    LaunchedEffect(key1 = allowClick) {
        if (!allowClick) {
            delay(3000)
            allowClick = true
        }
    }
}

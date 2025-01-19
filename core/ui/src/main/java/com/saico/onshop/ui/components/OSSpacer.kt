package com.saico.onshop.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.saico.onshop.ui.theme.PaddingDim

@Composable
fun SpacerHeight(
    height: Dp = PaddingDim.LARGE,
) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun SpacerWidth(
    width: Dp = PaddingDim.LARGE,
) {
    Spacer(modifier = Modifier.width(width))
}

package com.saico.onshop.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOff
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchColors
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LocationSwitch(
    isServiceEnable: Boolean,
    setInitLocation: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    colors: SwitchColors = SwitchDefaults.colors(),
) {
    Switch(
        modifier = modifier,
        colors = colors,
        checked = isServiceEnable,
        onCheckedChange = setInitLocation,
        thumbContent = {
            Icon(
                imageVector =
                if (isServiceEnable) {
                    Icons.Filled.LocationOn
                } else {
                    Icons.Filled.LocationOff
                },
                contentDescription = "Location On",
                modifier = Modifier.size(20.dp)
            )
        }
    )
}
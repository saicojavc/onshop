package com.saico.onshop.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saico.onshop.ui.theme.CornerDim
import com.saico.onshop.ui.theme.ElevationDim
import com.saico.onshop.ui.theme.PaddingDim

@Composable
fun OSOption(
    component: @Composable () -> Unit,
    title: Int,
    description: Int,
) {
    OSElevatedCard(
        shape = RoundedCornerShape(CornerDim.MEDIUM),
        elevation = ElevationDim.SMALL,
        modifier = Modifier.padding(PaddingDim.VERY_SMALL)
    ) {
        Row(Modifier.fillMaxWidth()) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp)
                    .padding(start = 6.dp, top = 6.dp, bottom = 4.dp)
                    .align(Alignment.CenterVertically)
                    .weight(0.80f)
            ) {
                Text(
                    text = stringResource(id = title),
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif,
                    lineHeight = TextUnit.Unspecified
                )
                Text(
                    text = stringResource(id = description),
                    fontSize = 16.sp,
                    fontFamily = FontFamily.SansSerif,
                    lineHeight = TextUnit.Unspecified
                )
            }
            Box(
                modifier = Modifier
                    .weight(0.20f)
                    .align(Alignment.CenterVertically),
                contentAlignment = Alignment.Center
            ) { component() }
        }
    }
}

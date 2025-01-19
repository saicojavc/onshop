package com.saico.onshop.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import com.saico.onshop.ui.theme.FontSizes

@Composable
fun OSText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit = TextUnit.Unspecified,
    style: TextStyle = LocalTextStyle.current,
    color: Color = Color.Unspecified,
    maxLines: Int = 1,
    textAlign: TextAlign? = null,
    fontWeight: FontWeight? = null,
    overflow: TextOverflow = TextOverflow.Clip,
) {
    Text(
        text = text,
        modifier = modifier,
        style = style,
        color = color,
        maxLines = maxLines,
        textAlign = textAlign,
        fontSize = fontSize,
        overflow = overflow,
        fontWeight = fontWeight
    )
}

@Composable
fun OSTextTitle(
    modifier: Modifier = Modifier.fillMaxWidth(),
    text: String,
) {
    OSText(
        text = text, modifier = modifier,
        fontSize = FontSizes.TITLE_BIG,
        fontWeight = FontWeight.SemiBold
    )
}
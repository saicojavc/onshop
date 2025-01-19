package com.saico.onshop.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.saico.onshop.ui.R
import com.saico.onshop.ui.components.icon.OSIcons
import com.saico.onshop.ui.theme.LocalOsColor
import com.saico.onshop.ui.theme.PaddingDim
import com.saico.onshop.ui.theme.osColors

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OSBottomSheet(
    @StringRes title: Int = R.string.app_name,
    isVisible: Boolean,
    onDismissRequest: () -> Unit,
    content: @Composable (ColumnScope.() -> Unit),
) {
    val modalSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    if (isVisible) {
        ModalBottomSheet(
            modifier = Modifier.fillMaxSize(),
            sheetState = modalSheetState,
            containerColor = MaterialTheme.colorScheme.surface,
            onDismissRequest = onDismissRequest,
            tonalElevation = 0.dp,
            content = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = title),
                        modifier = Modifier.padding(start = PaddingDim.LARGE),
                        style = MaterialTheme.typography
                            .headlineSmall.copy(fontWeight = FontWeight.Bold)
                    )
                    OSTooltipIconButton(
                        onClick = onDismissRequest,
                        icon = OSIcons.ClearIcon,
                        contentDescription = stringResource(id = R.string.close),
                    )
                }
                HorizontalDivider(
                    modifier = Modifier.height(1.dp),
                    color = MaterialTheme.osColors.gris
                )
                content()
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OSInteractiveBottomSheet(
    isVisible: Boolean,
    sheetState: SheetState = rememberModalBottomSheetState(),
    containerColor: Color = BottomSheetDefaults.ContainerColor,
    contentColor: Color = contentColorFor(containerColor),
    scrimColor: Color = LocalOsColor.current.transparent,
    onDismissRequest: () -> Unit,
    content: @Composable (ColumnScope.() -> Unit),
) {

    /**
     * @param onDismissRequest: Se ejecuta cuando el usuario hace clic fuera de la hoja modal, después de que la hoja se haya animado a "Oculto".
     * @param modifier: Modificador opcional para la hoja modal.
     * @param sheetState: El estado de la hoja modal.
     * @param sheetMaxWidth: Tamaño máximo en píxeles que la hoja ocupará. Pasa "Dp.Unspecified" para una hoja que abarque todo el ancho de la pantalla.
     * @param shape: Forma de la hoja modal.
     * @param containerColor: Color de fondo de esta hoja modal.
     * @param contentColor: Color preferido para el contenido dentro de esta hoja modal. Por defecto, coincide con el color de contenido correspondiente al containerColor, o con el color de contenido local actual si containerColor no es un color del tema.
     * @param tonalElevation: Elevación tonal de esta hoja modal.------
     * @param scrimColor: Color de la franja que oscurece el contenido cuando la hoja modal está abierta.
     * @param dragHandle: Marcador visual opcional para deslizar la hoja modal.
     * @param windowInsets: Desplazamientos de ventana que se pasan a la ventana de la hoja modal mediante parámetros PaddingValues.
     * @param properties: ModalBottomSheetProperties para una mayor personalización del comportamiento de esta hoja modal.
     *@param content: El contenido que se mostrará dentro de la hoja modal.
     */


    if (isVisible) {
        ModalBottomSheet(
            modifier = Modifier.fillMaxWidth(),
            sheetState = sheetState,
            containerColor = containerColor,
            contentColor = contentColor,
            scrimColor = scrimColor,
            onDismissRequest = onDismissRequest,
            tonalElevation = BottomSheetDefaults.Elevation,
            content = { content() }
        )
    }
}

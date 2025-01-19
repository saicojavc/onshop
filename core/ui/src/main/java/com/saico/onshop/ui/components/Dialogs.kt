package com.saico.onshop.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.saico.onshop.ui.R
import com.saico.onshop.ui.theme.PaddingDim


@Composable
fun InfoDialog(@StringRes title: Int, @StringRes text: Int, onDismiss: () -> Unit) {
    OSAlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = stringResource(title),
            )
        },
        text = { Text(text = stringResource(text)) },
        confirmButton = {
            TextButton(onClick = onDismiss) { Text(text = stringResource(id = R.string.understood)) }
        },
    )
}

@Composable
fun OSInfoDialog(
    isVisible: Boolean,
    @StringRes title: Int,
    text: String,
    onDismiss: () -> Unit,
) {
    if (isVisible) {
        OSAlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(
                    text = stringResource(title),
                )
            },
            text = { Text(text = text) },
            confirmButton = {
                TextButton(onClick = onDismiss) { Text(text = stringResource(id = R.string.understood)) }
            },
        )
    }
}

@Composable
fun LoadingDialog(@StringRes textMsg: Int? = null) {
    Dialog(onDismissRequest = {}) {
        Surface(
            shape = AlertDialogDefaults.shape,
            color = MaterialTheme.colorScheme.surface,
        ) {
            Column(
                modifier = Modifier
                    .padding(all = PaddingDim.EXTRA_LARGE),
                verticalArrangement = Arrangement.spacedBy(PaddingDim.SMALL),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                CircularProgressIndicator()
                textMsg?.let {
                    Text(
                        text = stringResource(
                            id = it
                        ),
                        color = AlertDialogDefaults.textContentColor,
                    )
                }
            }
        }
    }

}

@Composable
fun OSDialog(
    onDismiss: () -> Unit,
    @StringRes title: Int,
    text: String,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    dismissButton: @Composable (() -> Unit)? = null,
    neutralButton: @Composable (() -> Unit)? = null,
    confirmButton: @Composable () -> Unit,
) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            modifier = modifier,
            shape = AlertDialogDefaults.shape,
            color = MaterialTheme.colorScheme.surface,
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(PaddingDim.LARGE),
                modifier = Modifier
                    .padding(PaddingDim.EXTRA_LARGE)
            ) {
                icon?.let {
                    Icon(
                        imageVector = it,
                        contentDescription = null,
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        tint = AlertDialogDefaults.iconContentColor,
                    )
                }
                Text(
                    text = stringResource(id = title),
                    modifier = Modifier.align(if (icon != null) Alignment.CenterHorizontally else Alignment.Start),
                    style = MaterialTheme.typography.headlineSmall,
                    color = AlertDialogDefaults.titleContentColor,
                )
                Text(
                    text = text,
                    modifier = Modifier.fillMaxWidth(),
                    style = MaterialTheme.typography.bodySmall,
                    color = AlertDialogDefaults.textContentColor,
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = PaddingDim.VERY_SMALL)
                ) {
                    neutralButton?.let { it() } ?: Text(text = "")

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        dismissButton?.let { it() }
                        confirmButton()
                    }
                }
            }
        }
    }
}

@Composable
fun OSAlertDialog(
    onDismissRequest: () -> Unit,
    confirmButton: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    dismissButton: @Composable (() -> Unit)? = null,
    icon: @Composable (() -> Unit)? = null,
    title: @Composable (() -> Unit)? = null,
    text: @Composable (() -> Unit)? = null,
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = confirmButton,
        modifier = modifier,
        dismissButton = dismissButton,
        icon = icon,
        title = title,
        text = text,
        tonalElevation = 0.dp
    )
}


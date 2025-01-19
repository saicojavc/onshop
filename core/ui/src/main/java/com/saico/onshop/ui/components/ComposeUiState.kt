package com.saico.onshop.ui.components

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.saico.onshop.ui.R
import com.saico.onshop.ui.util.UiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

@Composable
fun <T> SimpleUiState(
    uiState: Flow<UiState<T>>,
    onError: () -> Unit = {},
    onSuccess: (T?) -> Unit,
) {
    var infoDialog: DialogDataNet? by remember {
        mutableStateOf(value = null)
    }

    LaunchedEffect(key1 = true) {
        uiState.collectLatest { uiState ->
            infoDialog = when (uiState) {
                is UiState.Error -> {
                    DialogDataNet.InfoDialogData(
                        title = R.string.error,
                        text = uiState.message
                    )
                }

                is UiState.Loading -> {
                    DialogDataNet.LoadDialogData(uiState.message)
                }

                is UiState.Success -> {
                    null
                }
            }

            if (uiState is UiState.Success) {
                onSuccess(uiState.data)
            }
        }
    }

    when (infoDialog) {
        is DialogDataNet.InfoDialogData -> {
            InfoDialog(
                title = (infoDialog as? DialogDataNet.InfoDialogData)?.title ?: R.string.error,
                text = infoDialog?.info ?: R.string.http_error_generic
            ) {
                infoDialog = null
                onError()
            }
        }

        is DialogDataNet.LoadDialogData -> {
            LoadingDialog(textMsg = infoDialog?.info)
        }

        null -> {}
    }
}

sealed class DialogDataNet(@StringRes val info: Int?) {
    data class InfoDialogData(
        @StringRes val title: Int,
        @StringRes val text: Int,
    ) : DialogDataNet(text)

    data class LoadDialogData(
        @StringRes val text: Int?,
    ) : DialogDataNet(text)
}
package com.saico.onshop.ui.util

import androidx.annotation.StringRes

sealed interface UiState<out T : Any?> {
    /**
     * @param data was success*/
    data class Success<T>(val data: T? = null, @StringRes val message: Int? = null) : UiState<T>
    data class Error(@StringRes val message: Int) : UiState<Nothing>
    data class Loading(@StringRes val message: Int? = null) : UiState<Nothing>
}
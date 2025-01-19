package com.saico.onshop.model

sealed class ResultValue<out T : Any?> {
    data class Success<out T>(val data: T) : ResultValue<T>()
    data class Error(val exception: Exception) : ResultValue<Nothing>()
}
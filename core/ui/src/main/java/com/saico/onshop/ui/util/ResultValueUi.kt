package com.saico.onshop.ui.util

import androidx.annotation.StringRes
import com.saico.onshop.model.ResultValue
import com.saico.onshop.model.exception.NetworkResponseException
import com.saico.onshop.model.exception.NetworkResponseException.Companion.DEFAULT_ERROR_CODE
import com.saico.onshop.ui.R


sealed class ResultValueUi<out T : Any?> {
    data object Loading : ResultValueUi<Nothing>()
    data class Success<out T>(val data: T? = null) : ResultValueUi<T>()
    data class Error(@StringRes val errorRes: Int, val code: Int?) : ResultValueUi<Nothing>()
}

fun ResultValue.Error.asUiError(): ResultValueUi.Error {
    val code: Int? = (this.exception as? NetworkResponseException)?.errorCode
    return ResultValueUi.Error(errorRes = remoteErrorMap[code]!!, code = code)
}

fun ResultValue.Error.asLoginUiError(): ResultValueUi.Error {
    return when (val code: Int? = (this.exception as? NetworkResponseException)?.errorCode) {
        400 -> {
            ResultValueUi.Error(errorRes = R.string.wrong_password, code)
        }

        403 -> {
            ResultValueUi.Error(errorRes = R.string.blocked_password, code)
        }

        406 -> {
            ResultValueUi.Error(errorRes = R.string.expired_password, code)
        }

        else -> {
            ResultValueUi.Error(
                errorRes = remoteErrorMap[code] ?: remoteErrorMap[DEFAULT_ERROR_CODE]!!, code
            )
        }
    }
}

val remoteErrorMap: Map<Int?, Int> = mapOf(
    400 to R.string.http_error_400,
    401 to R.string.http_error_401,
    402 to R.string.http_error_402,
    403 to R.string.http_error_403,
    404 to R.string.http_error_404,
    405 to R.string.http_error_405,
    406 to R.string.http_error_406,
    407 to R.string.http_error_407,
    408 to R.string.http_error_408,
    409 to R.string.http_error_409,
    410 to R.string.http_error_410,
    411 to R.string.http_error_411,
    412 to R.string.http_error_412,
    413 to R.string.http_error_413,
    414 to R.string.http_error_414,
    415 to R.string.http_error_415,
    416 to R.string.http_error_416,
    417 to R.string.http_error_417,
    418 to R.string.http_error_418,
    421 to R.string.http_error_421,
    422 to R.string.http_error_422,
    423 to R.string.http_error_423,
    424 to R.string.http_error_424,
    426 to R.string.http_error_426,
    428 to R.string.http_error_428,
    429 to R.string.http_error_429,
    431 to R.string.http_error_431,
    451 to R.string.http_error_451,
    500 to R.string.http_error_500,
    501 to R.string.http_error_501,
    502 to R.string.http_error_502,
    503 to R.string.http_error_503,
    504 to R.string.http_error_504,
    505 to R.string.http_error_505,
    506 to R.string.http_error_506,
    507 to R.string.http_error_507,
    508 to R.string.http_error_508,
    510 to R.string.http_error_510,
    511 to R.string.http_error_511,
    DEFAULT_ERROR_CODE to R.string.http_error_generic,
    null to R.string.http_error_generic,
)

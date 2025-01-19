package com.saico.onshop.common.util

import java.math.RoundingMode

fun Long.roundDecimals(newScale: Int = 1, roundingMode: RoundingMode = RoundingMode.HALF_EVEN) =
    this.toBigDecimal().setScale(newScale, roundingMode).toLong()

fun Double.roundDecimals(newScale: Int = 1, roundingMode: RoundingMode = RoundingMode.HALF_EVEN) =
    this.toBigDecimal().setScale(newScale, roundingMode).toDouble()

fun Float.roundDecimals(newScale: Int = 1, roundingMode: RoundingMode = RoundingMode.HALF_EVEN) =
    this.toBigDecimal().setScale(newScale, roundingMode).toFloat()

fun Int.roundDecimals(newScale: Int = 1, roundingMode: RoundingMode = RoundingMode.HALF_EVEN) =
    this.toBigDecimal().setScale(newScale, roundingMode).toFloat()

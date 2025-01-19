package com.saico.onshop.common.util

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.Date
import java.util.Locale

/**
 * Format Date yyyy-MM-dd h:mm => (2022,08,10 10:54)
 */
fun String.dateStringToLong(): Long? {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd h:mm", Locale.getDefault())
    return try {
        val date = dateFormat.parse(this)
        date!!.time
    } catch (e: Exception) {
        null
    }
}


fun longToDate(dateLong: Long): Date {
    return Date(dateLong)
}


fun Date.dateToString(pattern: String? = "yyyy-MM-dd h:mm"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    return dateFormat.format(this)
}

fun LocalDateTime.dateTimeToString(): String {
    val dateTime = this
    val year = dateTime.year
    val month = dateTime.monthValue
    val dayOfMonth = dateTime.dayOfMonth
    val hour = if (dateTime.hour < 10) "0${dateTime.hour}" else dateTime.hour
    val minute = if (dateTime.minute < 10) "0${dateTime.minute}" else dateTime.minute
    val second = if (dateTime.second < 10) "0${dateTime.second}" else dateTime.second

    return "$year-$month-$dayOfMonth $hour:$minute:$second"
}

/**
 * From doc
 * */
fun Context.findActivity(): Activity {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) return context
        context = context.baseContext
    }
    throw IllegalStateException("No activity")
}
fun generateUniqueLong(): Long = System.currentTimeMillis()
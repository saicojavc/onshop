package com.saico.onshop.common.util

import android.annotation.SuppressLint
import android.os.Build
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone

enum class DateFormatStyle { MEDIUM, FULL, SHORT, LONG }

//TODO migrate this
@SuppressLint("SimpleDateFormat")
fun shortDateToLongDate(
    shortDate: String,
    formatStyle: DateFormatStyle = DateFormatStyle.MEDIUM,
): String {
    if (shortDate == "") return ""
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val date = LocalDate.parse(shortDate.substring(0, 10))
        val formatter = DateTimeFormatter.ofLocalizedDate(
            when (formatStyle) {
                DateFormatStyle.MEDIUM -> {
                    FormatStyle.MEDIUM
                }

                DateFormatStyle.SHORT -> {
                    FormatStyle.SHORT
                }

                DateFormatStyle.LONG -> {
                    FormatStyle.LONG
                }

                DateFormatStyle.FULL -> {
                    FormatStyle.FULL
                }
            }
        )
        date.format(formatter)
    } else {
        val date = SimpleDateFormat("yyyy-MM-dd").parse(shortDate.substring(0, 10))
        val formatter = DateFormat.getDateInstance(
            when (formatStyle) {
                DateFormatStyle.MEDIUM -> {
                    DateFormat.MEDIUM
                }

                DateFormatStyle.SHORT -> {
                    DateFormat.SHORT
                }

                DateFormatStyle.LONG -> {
                    DateFormat.LONG
                }

                DateFormatStyle.FULL -> {
                    DateFormat.FULL
                }
            }
        )
        formatter.format(date ?: "")
    }
}

fun Long.asCalendar(): Calendar = Calendar.getInstance().apply {
    timeInMillis = this@asCalendar
    add(Calendar.DAY_OF_YEAR, 1)
    set(Calendar.HOUR_OF_DAY, 0)
    set(Calendar.MINUTE, 0)
}

@SuppressLint("SimpleDateFormat")
fun Calendar.asFullFormattedString(): String = run {
    val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    formatter.format(this.time)
}

@SuppressLint("SimpleDateFormat")
fun Calendar.asFormattedString(): String = run {
    val formatter = SimpleDateFormat("yyyy-MM-dd")
    formatter.format(this.time)
}

fun Long.dateFormat(): String {
    val timeZoneUTC = TimeZone.getDefault()
    val offsetFromUTC = timeZoneUTC.getOffset(Date().time) * -1
    return Date(this + offsetFromUTC).toStringDate()
}

@SuppressLint("SimpleDateFormat")
fun Long.asFullFormattedString(): String = run {
    val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = Date(this)
    return format.format(date)
}

@Suppress("MagicNumber")
fun String.toDate(formatStyle: FormatStyle = FormatStyle.MEDIUM): String {
    val date = LocalDate.parse(this.substring(0, 10))
    val formatter = DateTimeFormatter.ofLocalizedDate(formatStyle)
    return date.format(formatter)
}

fun Date.toStringDate(pattern: String = "yyyy-MM-dd"): String {
    val oldFormatter = SimpleDateFormat(pattern, Locale.getDefault())
    return oldFormatter.format(this)
}

object DateUtil {

    //Useful date formats.
    const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    const val DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd"
    const val DATE_FORMAT_EEE = "EEEE"
    const val DATE_FORMAT_EEE_dd = "EEEE dd"
    const val DATE_FORMAT_dd = "dd"
    const val DATE_FORMAT_MMM = "MMM"
    const val DATE_FORMAT_MMMM = "MMMM"

    private const val HOURS_IN_MILLS_24: Long = 24 * 60 * 60 * 1000L

    //Calendar instance.
    private fun calendar(): Calendar = Calendar.getInstance(Locale.getDefault())

    /**
     * Provide current calendar's time value in milliseconds.
     * @param calendar Calendar instance to use. A private instance will be used by default.
     */
    fun timeInMillis(calendar: Calendar = calendar()): Long = calendar.timeInMillis

    /**
     * Provide current date.
     * @param calendar Calendar instance to use. A private instance will be used by default.
     * @param dateFormat [DateFormat] to use for date string representation. yyyy-MM-dd format will be used by default.
     */
    fun today(
        calendar: Calendar = calendar(),
        dateFormat: DateFormat = SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD, Locale.getDefault()),
    ): String = dateFormat.format(calendar.time)

    /**
     * Detect if a timestamp is on the current day.
     * @param timestamp Time value in milliseconds.
     * @return True if the timestamp is for the current day. Otherwise, it returns false.
     * For a negative value or a timestamp greater than the current timestamp, false is returned.
     */
    fun happenedToday(timestamp: Long): Boolean {
        val currentTime: Long = timeInMillis()
        if (timestamp < 0 || timestamp > currentTime) return false
        val timelapse: Long = currentTime - timestamp
        return timelapse <= HOURS_IN_MILLS_24
    }

    /**
     * Convert hours to milliseconds.
     */
    fun Int.hoursToMills(): Long =
        this /*hours*/ * 60  /*minutes*/ * 60/*seconds*/ * 1000L/*milliseconds*/

    /**
     * Convert minutes to milliseconds.
     */
    fun Int.minutesToMills(): Long =
        this /*minutes*/ * 60/*seconds*/ * 1000L/*milliseconds*/

    /**
     * Convert seconds to milliseconds.
     */
    fun Int.secondsToMills(): Long =
        this /*seconds*/ * 1000L/*milliseconds*/

    /**
     * Provide the current calendar year.
     * @param calendar Calendar instance to use. A private instance will be used by default.
     * @return Current year number.
     */
    fun currentYear(calendar: Calendar = calendar()): Int = calendar.get(Calendar.YEAR)

    /**
     * Provide the current calendar week day.
     * @param calendar Calendar instance to use. A private instance will be used by default.
     * @return Day week identifier. See [WEEK_DAYS_MAP].
     */
    fun currentWeekDay(calendar: Calendar = calendar()): Int =
        calendar.get(Calendar.DAY_OF_WEEK)

    /**
     * Convert milliseconds to a formatted string date using [toDate] method.
     * @param formatStyle Date format style for the output string.
     * @return Formatted string date.
     */
    fun Long.millisToFormattedDate(
        formatStyle: FormatStyle = FormatStyle.MEDIUM,
    ): String = SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD, Locale.getDefault()).format(this)
        .toDate(formatStyle = formatStyle)

    /**
     * Convert a string to a styled string date if is possible.
     * @param formatStyle Date format style for the output string.
     * @return Formatted string date.
     */
    fun String.toDate(formatStyle: FormatStyle = FormatStyle.MEDIUM): String {
        val date = LocalDate.parse(this)
        val formatter = DateTimeFormatter.ofLocalizedDate(formatStyle)
        return date.format(formatter)
    }

}
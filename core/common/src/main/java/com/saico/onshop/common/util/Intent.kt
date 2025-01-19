package com.saico.onshop.common.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri

/**
 * Intent for open a web page
 * @param url Url of the web page to open
 */

@SuppressLint("QueryPermissionsNeeded")
fun Context.openWebPage(url: String): Boolean {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    return if (intent.resolveActivity(packageManager) != null) {
        startActivity(intent)
        true
    } else false
}

/**
 * Intent for send a email
 *
 * @param emails List of emails
 * @param subject  Subject of the email
 * @param message Message of the email
 */
@SuppressLint("IntentReset", "QueryPermissionsNeeded")
fun Context.sendEmail(
    emails: Array<String?>,
    subject: String?,
    message: String? = null,
): Boolean {
    val intent = Intent(Intent.ACTION_SENDTO)
        .setType("message/rfc822")
        .setData(Uri.parse("mailto:"))
        .putExtra(Intent.EXTRA_EMAIL, emails)
        .putExtra(Intent.EXTRA_SUBJECT, subject)
        .putExtra(Intent.EXTRA_TEXT, message)
    return if (intent.resolveActivity(packageManager) != null) {
        startActivity(intent)
        true
    } else false
}

fun Context.locateAtMap(
    latitude: String,
    longitude: String,
    label: String? = null,
): Boolean {
    val geo = Uri.parse(
        "geo:$latitude,$longitude${if (label.isNullOrBlank()) "" else "?q=${Uri.encode("$latitude,$longitude(${label})")}"}"
    )
    val intent = Intent(Intent.ACTION_VIEW).apply { data = geo }
    return if (intent.resolveActivity(packageManager) != null) {
        startActivity(intent)
        true
    } else false
}

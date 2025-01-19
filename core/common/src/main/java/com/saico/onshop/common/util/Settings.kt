package com.saico.onshop.common.util

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.provider.Settings
import android.telephony.TelephonyManager
import androidx.activity.result.ActivityResultLauncher

/**
 * Navigate to App Information
 * @param response contain a registerForActivityResult function, with StartActivityForResult() as ActivityResultContracts
 * */

fun Activity.toAppInformation(response: ActivityResultLauncher<Intent>) {
    response.launch(
        Intent(
            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
        ).apply {
            data = Uri.fromParts("package", packageName, null)
        }
    )
}

@Suppress("DEPRECATION")
@SuppressLint("MissingPermission", "UseRequireInsteadOfGet", "HardwareIds")
fun Context.getIMEI(): String {
    return if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P) {
        Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
            .substring(0, 15)
    } else {
        val telephonyManager =
            getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && Build.VERSION.SDK_INT <= Build.VERSION_CODES.P && telephonyManager.imei != null) {
            telephonyManager.imei
        } else if (telephonyManager.deviceId != null) {
            telephonyManager.deviceId
        } else {
            Settings.Secure.getString(
                contentResolver,
                Settings.Secure.ANDROID_ID
            ).substring(0, 15)
        }
    }
}


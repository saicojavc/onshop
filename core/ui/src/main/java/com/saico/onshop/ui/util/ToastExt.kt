package com.saico.onshop.ui.util

import android.content.Context
import android.widget.Toast

/**
 * Show a toast with LENGTH_SHORT
 * @param msg String
 */
fun Context.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).apply {
        show()
    }
}

/**
 * Show a toast with LENGTH_SHORT
 * @param msg String
 */
fun Context.longToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).apply {
        show()
    }
}

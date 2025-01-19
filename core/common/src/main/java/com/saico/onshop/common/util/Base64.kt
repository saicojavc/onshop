package com.saico.onshop.common.util

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import java.nio.charset.StandardCharsets

/**
 * Codify a string has Base64.
 * @param toEncode String to encode.
 */
fun base64Encode(toEncode: String): String =
    Base64.encodeToString(toEncode.toByteArray(), Base64.NO_WRAP).trim()

/**
 * Codify a byteArray has Base64.
 * @param toEncode ByteArray to encode.
 */
fun base64Encode(toEncode: ByteArray): String =
    Base64.encodeToString(toEncode, Base64.NO_WRAP).trim()


/**
 * Decode a Base64 with UTF-8 Charset to string.
 * @param encodedString Encoded UTF-8 string to decode.
 */
fun base64DecodeUTF8(encodedString: String): String =
    String(Base64.decode(encodedString, Base64.DEFAULT), StandardCharsets.UTF_8).trim()

/**
 * Codify a url has Base 64
 * @param url url as ByteArray to code
 */
fun base64UrlEncode(url: ByteArray): String =
    Base64.encodeToString(url, Base64.URL_SAFE or Base64.NO_PADDING or Base64.NO_WRAP).trim()

/**
 * Codify a byteArray has Base64 with UTF-8 Charset.
 * @param toEncode String to encode.
 */
fun base64EncodeUTF8(toEncode: String): String =
    Base64.encodeToString(toEncode.toByteArray(StandardCharsets.UTF_8), Base64.DEFAULT).trim()

/**
 * Decode a Base64 to string.
 * @param encodedString Encoded string to decode.
 */
fun base64Decode(encodedString: String): String =
    String(Base64.decode(encodedString, Base64.NO_WRAP)).trim()

fun base64ToBitmap(avatarBase64: String?): Bitmap? =
    if (avatarBase64 != null) try {
        val decodedString = Base64.decode(avatarBase64, Base64.DEFAULT)
        BitmapFactory.decodeByteArray(decodedString, 0, decodedString.size)
    } catch (e: Exception) {
        null
    } else null

package com.saico.onshop.common.util

import java.util.regex.Pattern

private object Regex {
    //Regex for validate email address
    const val REGEX_EMAIL_VALIDATION =
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"

    //Regex for validate identity card of 11 digit
    const val REGEX_IDENTITY_CARD_VALIDATION =
        "^([1-9][0-9]{0,12})?(\\\\.[0-9]?)?\$"

}

fun String.isValidEmail(): Boolean = Pattern.compile(Regex.REGEX_EMAIL_VALIDATION)
    .matcher(this).matches()


fun String.isValidIdentityCard(): Boolean = Pattern.compile(Regex.REGEX_IDENTITY_CARD_VALIDATION)
    .matcher(this).matches()


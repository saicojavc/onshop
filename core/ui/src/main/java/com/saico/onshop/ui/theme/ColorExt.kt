package com.saico.onshop.ui.theme

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf

@Immutable
data class DarkMode(val isDarkMode: Boolean)

val LocalIsDarkMode = staticCompositionLocalOf {
    DarkMode(isDarkMode = false)
}


private val darkMode: DarkMode
    @Composable
    get() = LocalIsDarkMode.current

/**
 * Function for know if the theme is DarkTheme
 * This function is accessible in all project
 */
@Composable
fun isDarkTheme() = darkMode.isDarkMode

/**
 * Use this variable for access to all colors of the app.
 * Example of use [MaterialTheme.osColors.black]
 */
val MaterialTheme.osColors
    @Composable
    get() = LocalOsColor.current

@OptIn(ExperimentalMaterial3Api::class)
val OSTopAppColors: TopAppBarColors
    @Composable
    get() = TopAppBarDefaults.topAppBarColors(
        containerColor = MaterialTheme.colorScheme.background,
        titleContentColor = MaterialTheme.colorScheme.onBackground,
        navigationIconContentColor = MaterialTheme.colorScheme.onBackground,
    )
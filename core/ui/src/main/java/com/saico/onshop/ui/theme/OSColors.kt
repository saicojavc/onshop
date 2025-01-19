package com.saico.onshop.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red


val LocalOsColor: ProvidableCompositionLocal<OSColors> =
    staticCompositionLocalOf { OSColors() }

/**
 * All colors of the app
 * OSColors
 */
@Immutable
data class OSColors(

    //Natural Colors
    val black: Color = Color.Black,
    val white: Color = Color.White,
    val gold: Color = Gold,
    val green: Color = Green,
    val orange: Color = Orange,
    val transparent: Color = Color.Transparent,
    val blueCamp: Color = BlueCamp,
    val gris: Color = Gris,
    val red: Color = Red,

    //Notifications
    val notificationDefault: Color = ColorNotificationDefault,
    val notificationInfo: Color = ColorNotificationInfo,
    val notificationConfirmation: Color = ColorNotificationConfirmation,
    val notificationPublicity: Color = ColorNotificationPublicity,
    val notificationAlert: Color = ColorNotificationAlert,
    val notificationLink: Color = ColorNotificationLink,
    val notificationAdvice: Color = ColorNotificationAdvice,
    val notificationNew: Color = ColorNotificationNew,
    val notificationWarning: Color = ColorNotificationWarning,
    val notificationSelected: Color = ColorNotificationSelected,
)

object LightColors {
    val Primary = Primary040
    val OnPrimary = Primary100
    val PrimaryContainer = Primary090
    val OnPrimaryContainer = Primary010
    val PrimaryFixed = Primary090
    val PrimaryFixedDim = Primary080
    val OnPrimaryFixed = Primary010
    val OnPrimaryFixedVariant = Primary030

    val Secondary = Secondary040
    val OnSecondary = Secondary100
    val SecondaryContainer = Secondary090
    val OnSecondaryContainer = Secondary010
    val SecondaryFixed = Secondary090
    val SecondaryFixedDim = Secondary080
    val OnSecondaryFixed = Secondary010
    val OnSecondaryFixedVariant = Secondary030

    val Tertiary = Tertiary040
    val OnTertiary = Tertiary100
    val TertiaryContainer = Tertiary090
    val OnTertiaryContainer = Tertiary010
    val TertiaryFixed = Tertiary090
    val TertiaryFixedDim = Tertiary080
    val OnTertiaryFixed = Tertiary010
    val OnTertiaryFixedVariant = Tertiary030

    val Error = Error040
    val OnError = Error100
    val ErrorContainer = Error090
    val OnErrorContainer = Error010

    val SurfaceDim = Neutral087
    val Surface = Neutral098
    val SurfaceBright = Neutral098
    val SurfaceContainerLowest = Neutral100
    val SurfaceContainerLow = Neutral096
    val SurfaceContainer = Neutral094
    val SurfaceContainerHigh = Neutral092
    val SurfaceContainerHighest = Neutral090

    val SurfaceVariant = Neutral080
    val OnSurface = NeutralV010
    val OnSurfaceVariant = NeutralV030
    val Outline = NeutralV050
    val OutlineVariant = NeutralV080

    val InverseSurface = Neutral020
    val InverseOnSurface = Neutral095
    val InversePrimary = Primary080

    val Scrim = Neutral000
    val Shadow = Neutral000
}

object DarkColors {
    val Primary = Primary080
    val OnPrimary = Primary020
    val PrimaryContainer = Primary030
    val OnPrimaryContainer = Primary090
    val PrimaryFixed = Primary090
    val PrimaryFixedDim = Primary080
    val OnPrimaryFixed = Primary010
    val OnPrimaryFixedVariant = Primary030

    val Secondary = Secondary080
    val OnSecondary = Secondary020
    val SecondaryContainer = Secondary030
    val OnSecondaryContainer = Secondary090
    val SecondaryFixed = Secondary090
    val SecondaryFixedDim = Secondary080
    val OnSecondaryFixed = Secondary010
    val OnSecondaryFixedVariant = Secondary030

    val Tertiary = Tertiary080
    val OnTertiary = Tertiary020
    val TertiaryContainer = Tertiary030
    val OnTertiaryContainer = Tertiary090
    val TertiaryFixed = Tertiary090
    val TertiaryFixedDim = Tertiary080
    val OnTertiaryFixed = Tertiary010
    val OnTertiaryFixedVariant = Tertiary030

    val Error = Error080
    val OnError = Error020
    val ErrorContainer = Error030
    val OnErrorContainer = Error090

    val SurfaceDim = Neutral006
    val Surface = Neutral004
    val SurfaceBright = Neutral004
    val SurfaceContainerLowest = Neutral004
    val SurfaceContainerLow = Neutral010
    val SurfaceContainer = Neutral012
    val SurfaceContainerHigh = Neutral017
    val SurfaceContainerHighest = Neutral022

    val SurfaceVariant = Neutral020
    val OnSurface = NeutralV090
    val OnSurfaceVariant = NeutralV080
    val Outline = NeutralV060
    val OutlineVariant = NeutralV030

    val InverseSurface = Neutral090
    val InverseOnSurface = Neutral020
    val InversePrimary = Primary040

    val Scrim = Neutral000
    val Shadow = Neutral000
}

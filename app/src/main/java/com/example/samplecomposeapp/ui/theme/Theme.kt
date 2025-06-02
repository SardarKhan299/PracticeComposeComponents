package com.example.samplecomposeapp.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val lightScheme = lightColorScheme(
    primary = Color(0xFF6200EA), // Purple
    onPrimary = Color(0xFFFFFFFF), // White
    primaryContainer = Color(0xFFBB86FC), // Light Purple
    onPrimaryContainer = Color(0xFF3700B3), // Dark Purple
    secondary = Color(0xFF03DAC6), // Teal
    onSecondary = Color(0xFF000000), // Black
    secondaryContainer = Color(0xFF018786), // Dark Teal
    onSecondaryContainer = Color(0xFFB2DFDB), // Light Teal
    tertiary = Color(0xFFFF5722), // Deep Orange
    onTertiary = Color(0xFFFFFFFF), // White
    tertiaryContainer = Color(0xFFFFAB91), // Light Orange
    onTertiaryContainer = Color(0xFFBF360C), // Dark Orange
    error = Color(0xFFB00020), // Red
    onError = Color(0xFFFFFFFF), // White
    errorContainer = Color(0xFFFFCDD2), // Light Red
    onErrorContainer = Color(0xFFB71C1C), // Dark Red
    background = Color(0xFFFAFAFA), // Light Gray
    onBackground = Color(0xFF212121), // Dark Gray
    surface = Color(0xFFFFFFFF), // White
    onSurface = Color(0xFF000000), // Black
    surfaceVariant = Color(0xFFE0E0E0), // Medium Gray
    onSurfaceVariant = Color(0xFF616161), // Darker Gray
    outline = Color(0xFF757575), // Gray
    outlineVariant = Color(0xFFBDBDBD), // Lighter Gray
    scrim = Color(0xFF000000), // Black
    inverseSurface = Color(0xFF303030), // Dark Gray
    inverseOnSurface = Color(0xFFF5F5F5), // Almost White
    inversePrimary = Color(0xFF3700B3), // Dark Purple
    surfaceDim = Color(0xFFEEEEEE), // Light Gray
    surfaceBright = Color(0xFFFFFFFF), // White
    surfaceContainerLowest = Color(0xFFF2F2F2), // Very Light Gray
    surfaceContainerLow = Color(0xFFECECEC), // Soft Gray
    surfaceContainer = Color(0xFFE0E0E0), // Medium Gray
    surfaceContainerHigh = Color(0xFFD6D6D6), // Slightly Darker Gray
    surfaceContainerHighest = Color(0xFFBDBDBD), // Darker Gray
)

private val darkScheme = darkColorScheme(
    primary = Color(0xFFBB86FC), // Light Purple
    onPrimary = Color(0xFF000000), // Black
    primaryContainer = Color(0xFF6200EA), // Purple
    onPrimaryContainer = Color(0xFF3700B3), // Dark Purple
    secondary = Color(0xFF03DAC6), // Teal
    onSecondary = Color(0xFF000000), // Black
    secondaryContainer = Color(0xFF018786), // Dark Teal
    onSecondaryContainer = Color(0xFFB2DFDB), // Light Teal
    tertiary = Color(0xFFFF5722), // Deep Orange
    onTertiary = Color(0xFFFFFFFF), // White
    tertiaryContainer = Color(0xFFFFAB91), // Light Orange
    onTertiaryContainer = Color(0xFFBF360C), // Dark Orange
    error = Color(0xFFCF6679), // Light Red
    onError = Color(0xFF000000), // Black
    errorContainer = Color(0xFFB00020), // Red
    onErrorContainer = Color(0xFFFFCDD2), // Light Red
    background = Color(0xFF121212), // Dark Gray
    onBackground = Color(0xFFFFFFFF), // White
    surface = Color(0xFF212121), // Dark Gray
    onSurface = Color(0xFFFFFFFF), // White
    surfaceVariant = Color(0xFF424242), // Medium Gray
    onSurfaceVariant = Color(0xFFBDBDBD), // Light Gray
    outline = Color(0xFF757575), // Gray
    outlineVariant = Color(0xFF616161), // Slightly Lighter Gray
    scrim = Color(0xFF000000), // Black
    inverseSurface = Color(0xFFFAFAFA), // Light Gray
    inverseOnSurface = Color(0xFF212121), // Dark Gray
    inversePrimary = Color(0xFF3700B3), // Dark Purple
    surfaceDim = Color(0xFF1E1E1E), // Very Dark Gray
    surfaceBright = Color(0xFF2A2A2A), // Slightly Lighter Gray
    surfaceContainerLowest = Color(0xFF1A1A1A), // Very Dark Gray
    surfaceContainerLow = Color(0xFF242424), // Dark Gray
    surfaceContainer = Color(0xFF2E2E2E), // Medium Dark Gray
    surfaceContainerHigh = Color(0xFF383838), // Slightly Lighter Gray
    surfaceContainerHighest = Color(0xFF424242), // Lightest Dark Gray
)

@Composable
fun SampleComposeAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> darkScheme
        else -> lightScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
package com.hughod.aryatest.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val AryaColorScheme = lightColorScheme(
    primary = BluePrimary,
    secondary = GoldPrimary,
    tertiary = WhitePrimary,
)

@Composable
fun AryaTheme(
    content: @Composable () -> Unit,
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        // this side effect ensures status bar icons are white
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }

    MaterialTheme(
        colorScheme = AryaColorScheme,
        typography = Typography,
        content = content
    )
}

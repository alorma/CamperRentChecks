package com.alorma.camperrent

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

actual fun getPlatform(): Platform = AndroidPlatform()

class AndroidPlatform : Platform {
    @Composable
    override fun getLightColorScheme(): ColorScheme {
        return dynamicLightColorScheme(LocalContext.current)
    }

    @Composable
    override fun getDarkColorScheme(): ColorScheme {
        return dynamicDarkColorScheme(LocalContext.current)
    }
}
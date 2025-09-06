package com.alorma.camperrent

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable

interface Platform {
    @Composable
    fun getLightColorScheme(): ColorScheme
    @Composable
    fun getDarkColorScheme(): ColorScheme
}

expect fun getPlatform(): Platform
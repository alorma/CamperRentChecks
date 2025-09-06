package com.alorma.camperrent

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import org.koin.core.logger.Logger

interface Platform {
    @Composable
    fun getLightColorScheme(): ColorScheme
    @Composable
    fun getDarkColorScheme(): ColorScheme

    fun koinLogger(): Logger
}

expect fun getPlatform(): Platform
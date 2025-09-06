package com.alorma.camperrent

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import org.koin.core.logger.Logger
import org.koin.core.module.Module

interface Platform {
    @Composable
    fun getLightColorScheme(): ColorScheme
    @Composable
    fun getDarkColorScheme(): ColorScheme

    fun koinLogger(): Logger
}

expect fun getPlatform(): Platform


interface PlatformModule {
    fun getModule(): Module
}

expect fun getPlatformModule(): PlatformModule
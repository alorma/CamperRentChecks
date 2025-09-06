package com.alorma.camperrent

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

class JVMPlatform : Platform {
    @Composable
    override fun getLightColorScheme(): ColorScheme = lightColorScheme()

    @Composable
    override fun getDarkColorScheme(): ColorScheme = darkColorScheme()
}

actual fun getPlatform(): Platform = JVMPlatform()
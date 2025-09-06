package com.alorma.camperrent

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import org.koin.core.logger.PrintLogger

class JVMPlatform : Platform {
  @Composable
  override fun getLightColorScheme(): ColorScheme = lightColorScheme()

  @Composable
  override fun getDarkColorScheme(): ColorScheme = darkColorScheme()

  override fun koinLogger(): Logger = PrintLogger(level = Level.DEBUG)
}

actual fun getPlatform(): Platform = JVMPlatform()
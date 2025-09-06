package com.alorma.camperrent

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.logger.Level
import org.koin.core.logger.Logger

class AndroidPlatform : Platform {
  @Composable
  override fun getLightColorScheme(): ColorScheme {
    val context = LocalContext.current
    return dynamicLightColorScheme(context)
  }

  @OptIn(ExperimentalMaterial3ExpressiveApi::class)
  @Composable
  override fun getDarkColorScheme(): ColorScheme {
    val context = LocalContext.current
    return dynamicDarkColorScheme(context)
  }

  override fun koinLogger(): Logger = AndroidLogger(level = Level.DEBUG)
}

actual fun getPlatform(): Platform = AndroidPlatform()
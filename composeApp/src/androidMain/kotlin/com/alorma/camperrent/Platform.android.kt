package com.alorma.camperrent

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

class AndroidPlatform : Platform {
  @Composable
  override fun getLightColorScheme(): ColorScheme {
    val context = LocalContext.current
    return dynamicDarkColorScheme(context)
  }

  @Composable
  override fun getDarkColorScheme(): ColorScheme {
    val context = LocalContext.current
    return dynamicDarkColorScheme(context)
  }
}

actual fun getPlatform(): Platform = AndroidPlatform()
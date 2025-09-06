package com.alorma.camperrent

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.alorma.camperrent.data.getDatabaseBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import org.koin.core.module.Module
import org.koin.dsl.module

class AndroidPlatform : Platform {
  @Composable
  override fun getLightColorScheme(): ColorScheme {
    val context = LocalContext.current
    return dynamicLightColorScheme(context)
  }

  @Composable
  override fun getDarkColorScheme(): ColorScheme {
    val context = LocalContext.current
    return dynamicDarkColorScheme(context)
  }

  override fun koinLogger(): Logger = AndroidLogger(level = Level.DEBUG)
}

actual fun getPlatform(): Platform = AndroidPlatform()

class AndroidPlatformModule : PlatformModule {
  override fun getModule(): Module = module {
    factory { getDatabaseBuilder(androidContext()) }
  }
}

actual fun getPlatformModule(): PlatformModule = AndroidPlatformModule()
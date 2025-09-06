package com.alorma.camperrent

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import com.alorma.camperrent.data.getDatabaseBuilder
import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import org.koin.core.logger.PrintLogger
import org.koin.core.module.Module
import org.koin.dsl.module

class JVMPlatform : Platform {
  @Composable
  override fun getLightColorScheme(): ColorScheme {
    return lightColorScheme()
  }

  @Composable
  override fun getDarkColorScheme(): ColorScheme {
    return darkColorScheme()
  }

  override fun koinLogger(): Logger = PrintLogger(level = Level.DEBUG)
}

actual fun getPlatform(): Platform = JVMPlatform()

class JVMPlatformModule: PlatformModule {
  override fun getModule(): Module = module {
    factory { getDatabaseBuilder() }
  }
}

actual fun getPlatformModule(): PlatformModule = JVMPlatformModule()
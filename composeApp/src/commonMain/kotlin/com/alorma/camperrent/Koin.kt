package com.alorma.camperrent

import org.koin.core.context.startKoin
import org.koin.core.logger.Logger
import org.koin.dsl.bind
import org.koin.dsl.module

// Define your Koin module
val appModule = module {
  factory { getPlatform().koinLogger() } bind Logger::class

  includes(getPlatformModule().getModule())

}

// Function to initialize Koin
fun initKoin() {
  startKoin {
    modules(appModule)
  }
}

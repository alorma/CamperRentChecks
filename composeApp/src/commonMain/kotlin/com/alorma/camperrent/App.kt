package com.alorma.camperrent

import androidx.compose.runtime.Composable
import com.alorma.camperrent.ui.TodoScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject
import org.koin.core.logger.Logger

@Composable
@Preview
fun App() {
  KoinApplication(
    application = { initKoin() }
  ) {
    AppTheme {
      val logger = koinInject<Logger>()
      logger.debug("Starting TodoScreen")
      
      TodoScreen()
    }
  }
}
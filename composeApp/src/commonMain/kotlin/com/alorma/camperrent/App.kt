package com.alorma.camperrent

import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.alorma.camperrent.screen.home.HomeScreen
import com.alorma.camperrent.screen.home.HomeScreenRoute
import com.alorma.camperrent.screen.route.ScreenRoute
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinMultiplatformApplication
import org.koin.compose.koinInject
import org.koin.core.annotation.KoinExperimentalAPI
import org.koin.core.logger.Logger
import org.koin.dsl.KoinConfiguration

@OptIn(ExperimentalMaterial3ExpressiveApi::class, KoinExperimentalAPI::class)
@Composable
@Preview
fun App() {
  KoinMultiplatformApplication(
    config = KoinConfiguration { initKoin() },
  ) {
    AppTheme {

      val backStack = remember { mutableStateListOf<ScreenRoute>(HomeScreenRoute) }

      val logger = koinInject<Logger>()

      NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { route ->
          logger.debug(route.logName)
          when (route) {
            is HomeScreenRoute -> NavEntry(route) {
              HomeScreen()
            }

            else -> throw IllegalArgumentException("Unknown route: $route")
          }
        },
      )
    }
  }
}
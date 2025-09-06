package com.alorma.camperrent

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.alorma.camperrent.screen.home.HomeScreenRoute
import com.alorma.camperrent.screen.route.ScreenRoute
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.compose.koinInject
import org.koin.core.logger.Logger

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
@Preview
fun App() {
  KoinApplication(
    application = { initKoin() }
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
              Scaffold { paddingValues ->
                Box(
                  modifier = Modifier.fillMaxSize().padding(paddingValues),
                  contentAlignment = Alignment.Center,
                ) {
                  Text("Home Screen") // Replace with your home screen content
                }
              }
            }

            else -> throw IllegalArgumentException("Unknown route: $route")
          }
        },
      )
    }
  }
}
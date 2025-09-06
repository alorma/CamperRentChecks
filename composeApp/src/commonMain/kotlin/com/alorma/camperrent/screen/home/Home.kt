package com.alorma.camperrent.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.alorma.camperrent.screen.route.ScreenRoute

data object HomeScreenRoute : ScreenRoute {
  override val logName: String = "home"
}

@Composable
fun HomeScreen() {
  Scaffold { paddingValues ->
    Box(
      modifier = Modifier.fillMaxSize().padding(paddingValues),
      contentAlignment = Alignment.Center,
    ) {
      Text("Home Screen") // Replace with your home screen content
    }
  }
}
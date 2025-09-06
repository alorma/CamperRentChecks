package com.alorma.camperrent.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularWavyProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.alorma.camperrent.screen.route.ScreenRoute
import org.koin.compose.viewmodel.koinViewModel

data object HomeScreenRoute : ScreenRoute {
  override val logName: String = "home"
}

@OptIn(
  ExperimentalMaterial3ExpressiveApi::class,
  ExperimentalMaterial3Api::class,
)
@Composable
fun HomeScreen(
  viewModel: HomeViewModel = koinViewModel(),
) {
  Scaffold(
    topBar = {
      TopAppBar(
        title = { Text(text = "Rent checks") },
      )
    },
    floatingActionButton = {},
  ) { paddingValues ->
    val uiState = viewModel.uiState.collectAsState()

    Column(
      modifier = Modifier.fillMaxSize().padding(paddingValues),
    ) {
      Button(
        onClick = { viewModel.create() },
      ) {
        Text(text = "Create")
      }

      when (val state = uiState.value) {
        HomeState.Loading -> {
          Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
          ) {
            CircularWavyProgressIndicator()
          }
        }

        is HomeState.Loaded -> {
          Text(text = "Items: ${state.count}")
          LazyColumn(
            modifier = Modifier.fillMaxSize(),
          ) {
            items(state.items) { item ->
              Text(text = item.title)
            }
          }
        }
      }

    }
  }
}
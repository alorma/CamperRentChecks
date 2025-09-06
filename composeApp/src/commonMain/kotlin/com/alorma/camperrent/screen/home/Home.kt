package com.alorma.camperrent.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularWavyProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.alorma.camperrent.data.ReservationEntity
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
        title = { Text(text = "Camper Reservations") },
      )
    },
    floatingActionButton = {},
  ) { paddingValues ->
    val uiState = viewModel.uiState.collectAsState()

    Column(
      modifier = Modifier.fillMaxSize().padding(paddingValues),
    ) {
      Button(
        onClick = { viewModel.createSampleReservation() },
        modifier = Modifier.padding(16.dp)
      ) {
        Text(text = "Add Sample Reservations")
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
          Text(
            text = "Total Reservations: ${state.count}",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
          )
          
          LazyColumn(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            items(state.reservations) { reservation ->
              ReservationCard(reservation = reservation)
            }
          }
        }
      }
    }
  }
}

@Composable
private fun ReservationCard(reservation: ReservationEntity) {
  Card(
    modifier = Modifier.fillMaxWidth(),
    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
      ) {
        Text(
          text = reservation.camperModel,
          style = MaterialTheme.typography.titleMedium,
          fontWeight = FontWeight.Bold
        )
        ReservationStatusChip(status = reservation.status)
      }
      
      Text(
        text = "Customer: ${reservation.customerName}",
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.padding(top = 4.dp)
      )
      
      Text(
        text = "Dates: ${reservation.startDate} to ${reservation.endDate}",
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.padding(top = 2.dp)
      )
      
      Row(
        modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
      ) {
        Text(
          text = "€${reservation.pricePerDay}/day",
          style = MaterialTheme.typography.bodySmall
        )
        Text(
          text = "Total: €${reservation.totalPrice}",
          style = MaterialTheme.typography.bodyMedium,
          fontWeight = FontWeight.Bold
        )
      }
    }
  }
}

@Composable
private fun ReservationStatusChip(status: String) {
  val color = when (status.lowercase()) {
    "confirmed" -> MaterialTheme.colorScheme.primary
    "pending" -> MaterialTheme.colorScheme.secondary
    "completed" -> MaterialTheme.colorScheme.tertiary
    "cancelled" -> MaterialTheme.colorScheme.error
    else -> MaterialTheme.colorScheme.outline
  }
  
  Card(
    colors = CardDefaults.cardColors(containerColor = color)
  ) {
    Text(
      text = status.replaceFirstChar { it.uppercase() },
      style = MaterialTheme.typography.labelSmall,
      color = MaterialTheme.colorScheme.onPrimary,
      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
    )
  }
}
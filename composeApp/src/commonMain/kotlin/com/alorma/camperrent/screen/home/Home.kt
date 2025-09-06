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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularWavyProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
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
  onAddReservationClick: () -> Unit,
) {
  Scaffold(
    topBar = {
      TopAppBar(
        title = { Text(text = "Camper Reservations") },
      )
    },
    floatingActionButton = {
      FloatingActionButton(onClick = onAddReservationClick) {
        Icon(Icons.Filled.Add, contentDescription = "Add Reservation")
      }
    },
  ) { paddingValues ->
    val uiState = viewModel.uiState.collectAsState()

    Column(
      modifier = Modifier.fillMaxSize().padding(paddingValues),
    ) {
      Button(
        onClick = { viewModel.create() },
        modifier = Modifier.padding(16.dp)
      ) {
        Text(text = "Add Sample Reservation")
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
            text = "Reservations: ${state.count}",
            modifier = Modifier.padding(horizontal = 16.dp),
            style = MaterialTheme.typography.titleMedium
          )
          LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(16.dp),
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
private fun ReservationCard(
  reservation: ReservationEntity,
  modifier: Modifier = Modifier
) {
  Card(
    modifier = modifier.fillMaxWidth(),
    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
  ) {
    Column(
      modifier = Modifier.padding(16.dp),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      Text(
        text = reservation.customerName,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.Bold
      )
      
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
      ) {
        Text(
          text = "Check-in: ${reservation.checkInDate}",
          style = MaterialTheme.typography.bodyMedium
        )
        Text(
          text = "Check-out: ${reservation.checkOutDate}",
          style = MaterialTheme.typography.bodyMedium
        )
      }
      
      // Contact information section
      Column(
        verticalArrangement = Arrangement.spacedBy(4.dp)
      ) {
        Text(
          text = "📞 ${reservation.phone}",
          style = MaterialTheme.typography.bodySmall,
          color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        reservation.whatsapp?.let { whatsapp ->
          Text(
            text = "💬 $whatsapp",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )
        }
        
        reservation.email?.let { email ->
          Text(
            text = "✉️ $email",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
          )
        }
      }
    }
  }
}

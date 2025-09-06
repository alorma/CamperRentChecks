package com.alorma.camperrent.screen.reservation.create

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alorma.camperrent.screen.route.ScreenRoute

data object AddReservationScreenRoute : ScreenRoute {
  override val logName: String = "add_reservation"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddReservationScreen(
  onBack: () -> Unit,
) {
  var customerName by remember { mutableStateOf("") }
  var checkInDate by remember { mutableStateOf("") }
  var checkOutDate by remember { mutableStateOf("") }
  var phone by remember { mutableStateOf("") }
  var whatsapp by remember { mutableStateOf("") }
  var email by remember { mutableStateOf("") }

  Scaffold(
    topBar = {
      TopAppBar(
        title = { Text("Add New Reservation") },
        navigationIcon = {
          IconButton(onClick = onBack) {
            Icon(
              imageVector = Icons.AutoMirrored.Filled.ArrowBack,
              contentDescription = "Back",
            )
          }
        }
      )
    },
    bottomBar = {
      Button(
        modifier = Modifier
          .fillMaxWidth()
          .padding(WindowInsets.safeContent.asPaddingValues()),
        onClick = {

        },
      ) {
        Text("Save Reservation")
      }
    },
  ) { paddingValues ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)
        .padding(16.dp),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
      OutlinedTextField(
        value = customerName,
        onValueChange = { customerName = it },
        label = { Text("Customer Name") },
        modifier = Modifier.fillMaxWidth()
      )
      OutlinedTextField(
        value = checkInDate,
        onValueChange = { checkInDate = it },
        label = { Text("Check-in Date (e.g., YYYY-MM-DD)") },
        modifier = Modifier.fillMaxWidth()
      )
      OutlinedTextField(
        value = checkOutDate,
        onValueChange = { checkOutDate = it },
        label = { Text("Check-out Date (e.g., YYYY-MM-DD)") },
        modifier = Modifier.fillMaxWidth()
      )
      OutlinedTextField(
        value = phone,
        onValueChange = { phone = it },
        label = { Text("Phone Number") },
        modifier = Modifier.fillMaxWidth()
      )
      OutlinedTextField(
        value = whatsapp,
        onValueChange = { whatsapp = it },
        label = { Text("WhatsApp (Optional)") },
        modifier = Modifier.fillMaxWidth()
      )
      OutlinedTextField(
        value = email,
        onValueChange = { email = it },
        label = { Text("Email (Optional)") },
        modifier = Modifier.fillMaxWidth()
      )

      Spacer(modifier = Modifier.height(16.dp))
    }
  }
}

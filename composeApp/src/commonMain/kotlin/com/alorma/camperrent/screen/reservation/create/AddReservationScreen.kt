package com.alorma.camperrent.screen.reservation.create

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.alorma.camperrent.screen.route.ScreenRoute
import org.koin.compose.viewmodel.koinViewModel

data object AddReservationScreenRoute : ScreenRoute {
  override val logName: String = "add_reservation"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddReservationScreen(
  onBack: () -> Unit,
  viewModel: AddReservationViewModel = koinViewModel(),
) {

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
        onClick = { viewModel.saveReservation() },
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
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Customer Name") },
        value = viewModel.customerName,
        onValueChange = { viewModel.onCustomerNameChange(it) },
        keyboardOptions = KeyboardOptions(
          capitalization = KeyboardCapitalization.Words,
          autoCorrectEnabled = false,
          keyboardType = KeyboardType.Text,
          imeAction = ImeAction.Next,
        ),
        maxLines = 1,
        singleLine = true,
      )
      OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Check-in Date (e.g., YYYY-MM-DD)") },
        value = viewModel.checkInDate,
        onValueChange = { viewModel.onCheckInDateChange(it) },
        keyboardOptions = KeyboardOptions(
          capitalization = KeyboardCapitalization.None,
          autoCorrectEnabled = false,
          keyboardType = KeyboardType.Number,
          imeAction = ImeAction.Next,
        ),
        maxLines = 1,
        singleLine = true,
      )
      OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Check-out Date (e.g., YYYY-MM-DD)") },
        value = viewModel.checkOutDate,
        onValueChange = { viewModel.onCheckOutDateChange(it) },
        keyboardOptions = KeyboardOptions(
          capitalization = KeyboardCapitalization.None,
          autoCorrectEnabled = false,
          keyboardType = KeyboardType.Number,
          imeAction = ImeAction.Next,
        ),
        maxLines = 1,
        singleLine = true,
      )
      OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Phone Number") },
        value = viewModel.phone,
        onValueChange = { viewModel.onPhoneChange(it) },
        keyboardOptions = KeyboardOptions(
          capitalization = KeyboardCapitalization.None,
          autoCorrectEnabled = false,
          keyboardType = KeyboardType.Phone,
          imeAction = ImeAction.Next,
        ),
        maxLines = 1,
        singleLine = true,
      )
      OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text("WhatsApp") },
        supportingText = { Text("(Optional)") },
        value = viewModel.whatsapp,
        onValueChange = { viewModel.onWhatsappChange(it) },
        keyboardOptions = KeyboardOptions(
          capitalization = KeyboardCapitalization.None,
          autoCorrectEnabled = false,
          keyboardType = KeyboardType.Phone,
          imeAction = ImeAction.Next,
        ),
        maxLines = 1,
        singleLine = true,
      )
      OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        label = { Text("Email (Optional)") },
        supportingText = { Text("(Optional)") },
        value = viewModel.email,
        onValueChange = { viewModel.onEmailChange(it) },
        keyboardOptions = KeyboardOptions(
          capitalization = KeyboardCapitalization.None,
          autoCorrectEnabled = false,
          keyboardType = KeyboardType.Email,
          imeAction = ImeAction.Send,
        ),
        keyboardActions = KeyboardActions(onSend = { viewModel.saveReservation() }),
        maxLines = 1,
        singleLine = true,
      )
    }
  }
}

package com.alorma.camperrent.screen.reservation.create

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class AddReservationViewModel : ViewModel() {

  var customerName by mutableStateOf(TextFieldValue(""))
    private set
  var checkInDate by mutableStateOf(TextFieldValue(""))
    private set
  var checkOutDate by mutableStateOf(TextFieldValue(""))
    private set
  var phone by mutableStateOf(TextFieldValue(""))
    private set
  var whatsapp by mutableStateOf(TextFieldValue(""))
    private set
  var email by mutableStateOf(TextFieldValue(""))
    private set

  fun onCustomerNameChange(name: TextFieldValue) {
    customerName = name
  }

  fun onCheckInDateChange(date: TextFieldValue) {
    checkInDate = date
  }

  fun onCheckOutDateChange(date: TextFieldValue) {
    checkOutDate = date
  }

  fun onPhoneChange(phoneNumber: TextFieldValue) {
    phone = phoneNumber
  }

  fun onWhatsappChange(whatsappNumber: TextFieldValue) {
    whatsapp = whatsappNumber
  }

  fun onEmailChange(emailAddress: TextFieldValue) {
    email = emailAddress
  }

  fun saveReservation() {
    // TODO: Implement actual save logic, e.g., call a repository
    viewModelScope.launch {
      println("Saving reservation: $customerName, $checkInDate, $checkOutDate, $phone, $whatsapp, $email")
      // Simulate network call or database operation
    }
  }
}

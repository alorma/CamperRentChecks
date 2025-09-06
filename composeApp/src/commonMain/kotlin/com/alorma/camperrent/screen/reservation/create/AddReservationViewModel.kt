package com.alorma.camperrent.screen.reservation.create

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alorma.camperrent.data.ReservationDao
import com.alorma.camperrent.data.ReservationEntity
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AddReservationViewModel(
  private val reservationDao: ReservationDao,
) : ViewModel() {

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


    private var _sideEffect = Channel<AddReservationSideEffect>()
    val sideEffect = _sideEffect.receiveAsFlow()

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
    viewModelScope.launch {
      reservationDao.insert(
        ReservationEntity(
          customerName = customerName.text,
          checkInDate = checkInDate.text,
          checkOutDate = checkOutDate.text,
          phone = phone.text,
          whatsapp = whatsapp.text,
          email = email.text,
        ),
      )

        _sideEffect.send(AddReservationSideEffect.Close)
    }
  }
}

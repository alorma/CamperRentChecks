package com.alorma.camperrent.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alorma.camperrent.data.ReservationDao
import com.alorma.camperrent.data.ReservationEntity
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(
  private val reservationDao: ReservationDao,
) : ViewModel() {

  val uiState: StateFlow<HomeState> = reservationDao
    .getAllAsFlow()
    .map { reservations ->
      HomeState.Loaded(
        count = reservations.size,
        reservations = reservations,
      )
    }.stateIn(
      scope = viewModelScope,
      started = SharingStarted.WhileSubscribed(5000),
      initialValue = HomeState.Loading,
    )

  fun create() = viewModelScope.launch {
    val sampleReservations = listOf(
      ReservationEntity(
        customerName = "John Smith",
        checkInDate = "2024-01-15",
        checkOutDate = "2024-01-22",
        phone = "+1-555-0123",
        whatsapp = "+1-555-0123",
        email = "john.smith@email.com"
      ),
      ReservationEntity(
        customerName = "Sarah Johnson",
        checkInDate = "2024-01-20",
        checkOutDate = "2024-01-25",
        phone = "+1-555-0456",
        whatsapp = "+1-555-0456",
        email = "sarah.johnson@email.com"
      ),
      ReservationEntity(
        customerName = "Mike Davis",
        checkInDate = "2024-01-10",
        checkOutDate = "2024-01-17",
        phone = "+1-555-0789",
        whatsapp = null,
        email = "mike.davis@email.com"
      )
    )
    
    // Insert a random sample reservation
    val randomReservation = sampleReservations.random()
    reservationDao.insert(randomReservation)
  }

}
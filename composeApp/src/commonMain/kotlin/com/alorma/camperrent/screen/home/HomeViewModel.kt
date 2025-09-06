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
        vehicleModel = "VW California",
        checkInDate = "2024-01-15",
        checkOutDate = "2024-01-22",
        status = "CONFIRMED",
        totalPrice = 850.0,
        notes = "First time customer"
      ),
      ReservationEntity(
        customerName = "Sarah Johnson",
        vehicleModel = "Mercedes Marco Polo",
        checkInDate = "2024-01-20",
        checkOutDate = "2024-01-25",
        status = "PENDING",
        totalPrice = 975.0,
        notes = "Requested early check-in"
      ),
      ReservationEntity(
        customerName = "Mike Davis",
        vehicleModel = "Ford Transit Custom",
        checkInDate = "2024-01-10",
        checkOutDate = "2024-01-17",
        status = "COMPLETED",
        totalPrice = 720.0,
        notes = "Excellent customer, returned clean"
      )
    )
    
    // Insert a random sample reservation
    val randomReservation = sampleReservations.random()
    reservationDao.insert(randomReservation)
  }

}
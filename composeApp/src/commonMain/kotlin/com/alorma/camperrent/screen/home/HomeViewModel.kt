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

  fun createSampleReservation() = viewModelScope.launch {
    val sampleReservations = listOf(
      ReservationEntity(
        camperModel = "VW California",
        customerName = "John Doe",
        startDate = "2024-01-15",
        endDate = "2024-01-20",
        status = "confirmed",
        pricePerDay = 120.0,
        totalPrice = 600.0
      ),
      ReservationEntity(
        camperModel = "Mercedes Marco Polo",
        customerName = "Jane Smith",
        startDate = "2024-02-01",
        endDate = "2024-02-07",
        status = "pending",
        pricePerDay = 150.0,
        totalPrice = 900.0
      ),
      ReservationEntity(
        camperModel = "Ford Transit Custom",
        customerName = "Bob Johnson",
        startDate = "2024-01-25",
        endDate = "2024-01-28",
        status = "completed",
        pricePerDay = 100.0,
        totalPrice = 300.0
      )
    )
    
    sampleReservations.forEach { reservation ->
      reservationDao.insert(reservation)
    }
  }

}
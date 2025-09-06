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
        checkOutDate = "2024-01-22"
      ),
      ReservationEntity(
        customerName = "Sarah Johnson",
        checkInDate = "2024-01-20",
        checkOutDate = "2024-01-25"
      ),
      ReservationEntity(
        customerName = "Mike Davis",
        checkInDate = "2024-01-10",
        checkOutDate = "2024-01-17"
      )
    )
    
    // Insert a random sample reservation
    val randomReservation = sampleReservations.random()
    reservationDao.insert(randomReservation)
  }

}
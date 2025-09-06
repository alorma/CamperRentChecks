package com.alorma.camperrent.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alorma.camperrent.data.ReservationDao
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
  private val reservationDao: ReservationDao,
) : ViewModel() {

  val uiState: StateFlow<HomeState> =
    reservationDao
      .getAllAsFlow()
      .onStart { delay(1_000) }
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
}
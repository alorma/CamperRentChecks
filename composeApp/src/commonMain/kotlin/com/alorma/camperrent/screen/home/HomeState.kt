package com.alorma.camperrent.screen.home

import com.alorma.camperrent.data.ReservationEntity

sealed interface HomeState {
  data object Loading: HomeState
  data class Loaded(
    val count: Int,
    val reservations: List<ReservationEntity>,
  ): HomeState
}
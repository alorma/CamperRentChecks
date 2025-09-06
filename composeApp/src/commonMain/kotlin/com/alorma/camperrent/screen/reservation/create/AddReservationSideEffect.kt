package com.alorma.camperrent.screen.reservation.create

sealed interface AddReservationSideEffect {
  data object Close : AddReservationSideEffect
}
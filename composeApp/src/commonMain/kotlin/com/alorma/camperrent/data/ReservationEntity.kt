package com.alorma.camperrent.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ReservationEntity(
  @PrimaryKey(autoGenerate = true) val id: Long = 0,
  val customerName: String,
  val checkInDate: String,
  val checkOutDate: String
)
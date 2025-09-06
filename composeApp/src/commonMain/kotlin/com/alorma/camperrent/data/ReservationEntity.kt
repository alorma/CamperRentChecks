package com.alorma.camperrent.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ReservationEntity(
  @PrimaryKey(autoGenerate = true) val id: Long = 0,
  val customerName: String,
  val vehicleModel: String,
  val checkInDate: String,
  val checkOutDate: String,
  val status: String, // "CONFIRMED", "PENDING", "COMPLETED", "CANCELLED"
  val totalPrice: Double,
  val notes: String = ""
)
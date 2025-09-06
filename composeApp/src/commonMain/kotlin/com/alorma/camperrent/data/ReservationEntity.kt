package com.alorma.camperrent.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ReservationEntity(
  @PrimaryKey(autoGenerate = true) val id: Long = 0,
  val camperModel: String,
  val customerName: String,
  val startDate: String, // Using String for simplicity, could be LocalDate
  val endDate: String,
  val status: String, // "pending", "confirmed", "completed", "cancelled"
  val pricePerDay: Double,
  val totalPrice: Double
)
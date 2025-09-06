package com.alorma.camperrent.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "camper_rent_checks")
data class CamperRentCheck(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val camperName: String,
    val renterName: String,
    val checkInDate: String,
    val checkOutDate: String,
    val mileage: Int,
    val fuelLevel: Float,
    val damageNotes: String = "",
    val isCheckIn: Boolean = true,
    val timestamp: Long = System.currentTimeMillis()
)
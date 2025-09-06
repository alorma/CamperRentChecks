package com.alorma.camperrent.data

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("""
            CREATE TABLE IF NOT EXISTS `ReservationEntity` (
                `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                `camperModel` TEXT NOT NULL,
                `customerName` TEXT NOT NULL,
                `startDate` TEXT NOT NULL,
                `endDate` TEXT NOT NULL,
                `status` TEXT NOT NULL,
                `pricePerDay` REAL NOT NULL,
                `totalPrice` REAL NOT NULL
            )
        """.trimIndent())
    }
}
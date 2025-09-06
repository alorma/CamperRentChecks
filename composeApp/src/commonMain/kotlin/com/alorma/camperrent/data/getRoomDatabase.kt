package com.alorma.camperrent.data

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers

fun getRoomDatabase(
  builder: RoomDatabase.Builder<AppDatabase>
): AppDatabase {
  return builder
    .setDriver(BundledSQLiteDriver())
    .setQueryCoroutineContext(Dispatchers.IO)
    // Add migration when needed
    // .addMigrations(MIGRATION_1_2)
    .fallbackToDestructiveMigration() // For development only
    .build()
}
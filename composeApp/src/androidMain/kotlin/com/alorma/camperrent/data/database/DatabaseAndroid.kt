package com.alorma.camperrent.data.database

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers

// This would be used in Android implementation
actual fun createDatabase(): CamperRentDatabase {
    // In a real Android app, you would get the context from Application or DI
    // For now, this is just to show the structure
    TODO("Android context needed - implement in Application class")
}

// This function would be called from Android Application class
fun createAndroidDatabase(context: Context): CamperRentDatabase {
    return Room.databaseBuilder<CamperRentDatabase>(
        context = context.applicationContext,
        name = "camper_rent_checks.db"
    )
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
package com.alorma.camperrent.data.database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import java.io.File

actual fun createDatabase(): CamperRentDatabase {
    val databasePath = File(System.getProperty("java.io.tmpdir"), "camper_rent_checks.db")
    
    return Room.databaseBuilder<CamperRentDatabase>(
        name = databasePath.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
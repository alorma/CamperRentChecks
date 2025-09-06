package com.alorma.camperrent.data.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.alorma.camperrent.data.dao.CamperRentCheckDao
import com.alorma.camperrent.data.entities.CamperRentCheck
import kotlinx.coroutines.Dispatchers

@Database(
    entities = [CamperRentCheck::class],
    version = 1,
    exportSchema = false
)
abstract class CamperRentDatabase : RoomDatabase() {
    abstract fun camperRentCheckDao(): CamperRentCheckDao
}

// Common interface for database initialization
interface DatabaseProvider {
    fun getDatabase(): CamperRentDatabase
}

// Expect function for platform-specific database creation
expect fun createDatabase(): CamperRentDatabase

// Common database instance - can be used from common code
object DatabaseInstance {
    val database: CamperRentDatabase by lazy { createDatabase() }
}
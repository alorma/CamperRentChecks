package com.alorma.camperrent.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.alorma.camperrent.data.entities.CamperRentCheck
import kotlinx.coroutines.flow.Flow

@Dao
interface CamperRentCheckDao {
    
    @Query("SELECT * FROM camper_rent_checks ORDER BY timestamp DESC")
    fun getAllChecks(): Flow<List<CamperRentCheck>>
    
    @Query("SELECT * FROM camper_rent_checks WHERE id = :id")
    suspend fun getCheckById(id: Long): CamperRentCheck?
    
    @Query("SELECT * FROM camper_rent_checks WHERE camperName = :camperName ORDER BY timestamp DESC")
    fun getChecksByCamper(camperName: String): Flow<List<CamperRentCheck>>
    
    @Query("SELECT * FROM camper_rent_checks WHERE renterName = :renterName ORDER BY timestamp DESC")
    fun getChecksByRenter(renterName: String): Flow<List<CamperRentCheck>>
    
    @Query("SELECT * FROM camper_rent_checks WHERE isCheckIn = :isCheckIn ORDER BY timestamp DESC")
    fun getChecksByType(isCheckIn: Boolean): Flow<List<CamperRentCheck>>
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCheck(check: CamperRentCheck): Long
    
    @Update
    suspend fun updateCheck(check: CamperRentCheck)
    
    @Delete
    suspend fun deleteCheck(check: CamperRentCheck)
    
    @Query("DELETE FROM camper_rent_checks")
    suspend fun deleteAllChecks()
}
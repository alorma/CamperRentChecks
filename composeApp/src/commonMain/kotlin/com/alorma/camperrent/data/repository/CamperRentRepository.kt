package com.alorma.camperrent.data.repository

import com.alorma.camperrent.data.dao.CamperRentCheckDao
import com.alorma.camperrent.data.database.DatabaseInstance
import com.alorma.camperrent.data.entities.CamperRentCheck
import kotlinx.coroutines.flow.Flow

class CamperRentRepository {
    private val dao: CamperRentCheckDao = DatabaseInstance.database.camperRentCheckDao()
    
    fun getAllChecks(): Flow<List<CamperRentCheck>> = dao.getAllChecks()
    
    suspend fun getCheckById(id: Long): CamperRentCheck? = dao.getCheckById(id)
    
    fun getChecksByCamper(camperName: String): Flow<List<CamperRentCheck>> = 
        dao.getChecksByCamper(camperName)
    
    fun getChecksByRenter(renterName: String): Flow<List<CamperRentCheck>> = 
        dao.getChecksByRenter(renterName)
    
    fun getChecksByType(isCheckIn: Boolean): Flow<List<CamperRentCheck>> = 
        dao.getChecksByType(isCheckIn)
    
    suspend fun insertCheck(check: CamperRentCheck): Long = dao.insertCheck(check)
    
    suspend fun updateCheck(check: CamperRentCheck) = dao.updateCheck(check)
    
    suspend fun deleteCheck(check: CamperRentCheck) = dao.deleteCheck(check)
    
    suspend fun deleteAllChecks() = dao.deleteAllChecks()
    
    // Helper functions for creating sample data
    suspend fun createSampleData() {
        val sampleChecks = listOf(
            CamperRentCheck(
                camperName = "Adventure RV",
                renterName = "John Smith",
                checkInDate = "2024-09-01",
                checkOutDate = "2024-09-05",
                mileage = 45000,
                fuelLevel = 0.8f,
                damageNotes = "Small scratch on rear bumper",
                isCheckIn = true
            ),
            CamperRentCheck(
                camperName = "Family Explorer",
                renterName = "Sarah Johnson",
                checkInDate = "2024-09-03",
                checkOutDate = "2024-09-10",
                mileage = 32000,
                fuelLevel = 1.0f,
                damageNotes = "",
                isCheckIn = true
            ),
            CamperRentCheck(
                camperName = "Adventure RV",
                renterName = "John Smith",
                checkInDate = "2024-09-01",
                checkOutDate = "2024-09-05",
                mileage = 45200,
                fuelLevel = 0.3f,
                damageNotes = "Same scratch on rear bumper",
                isCheckIn = false
            )
        )
        
        sampleChecks.forEach { check ->
            insertCheck(check)
        }
    }
}
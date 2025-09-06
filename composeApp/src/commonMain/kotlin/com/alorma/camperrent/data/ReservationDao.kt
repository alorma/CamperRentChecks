package com.alorma.camperrent.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ReservationDao {
  @Insert
  suspend fun insert(reservation: ReservationEntity)

  @Query("SELECT count(*) FROM ReservationEntity")
  suspend fun count(): Int

  @Query("SELECT * FROM ReservationEntity ORDER BY startDate DESC")
  fun getAllAsFlow(): Flow<List<ReservationEntity>>

  @Query("SELECT * FROM ReservationEntity WHERE status = :status ORDER BY startDate DESC")
  fun getByStatusAsFlow(status: String): Flow<List<ReservationEntity>>
}
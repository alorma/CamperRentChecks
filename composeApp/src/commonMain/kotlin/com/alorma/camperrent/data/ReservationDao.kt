package com.alorma.camperrent.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ReservationDao {
  @Insert
  suspend fun insert(item: ReservationEntity)

  @Query("SELECT count(*) FROM ReservationEntity")
  suspend fun count(): Int

  @Query("SELECT * FROM ReservationEntity ORDER BY checkInDate DESC")
  fun getAllAsFlow(): Flow<List<ReservationEntity>>
}
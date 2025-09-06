package com.alorma.camperrent

import androidx.room.RoomDatabase
import com.alorma.camperrent.data.AppDatabase
import com.alorma.camperrent.data.getRoomDatabase
import com.alorma.camperrent.screen.home.HomeViewModel
import com.alorma.camperrent.screen.reservation.create.AddReservationViewModel
import org.koin.core.KoinApplication
import org.koin.core.logger.Logger
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

// Define your Koin module
val appModule = module {
  factory { getPlatform().koinLogger() } bind Logger::class

  includes(getPlatformModule().getModule())

  single { getRoomDatabase(get<RoomDatabase.Builder<AppDatabase>>()) }
  single { get<AppDatabase>().getReservationDao() }

  viewModelOf(::HomeViewModel)
  viewModelOf(::AddReservationViewModel)
}

// Function to initialize Koin
fun KoinApplication.initKoin() {
  modules(appModule)
}

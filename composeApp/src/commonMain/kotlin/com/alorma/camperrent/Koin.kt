package com.alorma.camperrent

import org.koin.core.context.startKoin
import org.koin.dsl.module

// Define your Koin module
val appModule = module {
    // Add your dependencies here later
    // Example: single<MyRepository> { MyRepositoryImpl() }
}

// Function to initialize Koin
fun initKoin() {
    startKoin {
        modules(appModule)
    }
}

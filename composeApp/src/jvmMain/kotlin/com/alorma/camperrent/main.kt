package com.alorma.camperrent

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "CamperRentChecks",
    ) {
        App()
    }
}
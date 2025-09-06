package com.alorma.camperrent.model

data class TodoTask(
    val id: Int,
    val title: String,
    val description: String = "",
    val isCompleted: Boolean = false
)
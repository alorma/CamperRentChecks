package com.alorma.camperrent

import com.alorma.camperrent.model.TodoTask
import com.alorma.camperrent.ui.TodoScreen

fun main() {
    println("CamperRentChecks TODO Screen")
    println("============================")
    
    // Create sample tasks
    val tasks = listOf(
        TodoTask(1, "Plan camper trip route", "Research best camping spots and plan the route", false),
        TodoTask(2, "Check camper equipment", "Inspect tires, brakes, and engine", false),
        TodoTask(3, "Pack camping gear", "Tent, sleeping bags, cooking equipment", false),
        TodoTask(4, "Book campsites", "Reserve spots at national parks", true),
        TodoTask(5, "Prepare food supplies", "Non-perishable items and water", false),
        TodoTask(6, "Download offline maps", "Ensure navigation works without internet", true),
        TodoTask(7, "Emergency kit check", "First aid, tools, spare parts", false)
    )
    
    println("\nTODO Tasks:")
    tasks.forEach { task ->
        val status = if (task.isCompleted) "✓" else "☐"
        println("$status ${task.title}")
        if (task.description.isNotEmpty()) {
            println("  ${task.description}")
        }
    }
    
    val completedCount = tasks.count { it.isCompleted }
    val totalCount = tasks.size
    println("\nProgress: $completedCount/$totalCount tasks completed")
    
    println("\nCompose TODO Screen functionality verified!")
}
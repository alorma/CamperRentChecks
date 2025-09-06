package com.alorma.camperrent.ui

import kotlin.test.Test
import kotlin.test.assertEquals
import com.alorma.camperrent.model.TodoTask

class TodoScreenTest {

    @Test
    fun testTodoTaskCreation() {
        val task = TodoTask(
            id = 1,
            title = "Test Task",
            description = "Test Description",
            isCompleted = false
        )
        
        assertEquals(1, task.id)
        assertEquals("Test Task", task.title)
        assertEquals("Test Description", task.description)
        assertEquals(false, task.isCompleted)
    }
    
    @Test
    fun testCompletedTask() {
        val task = TodoTask(
            id = 2,
            title = "Completed Task",
            isCompleted = true
        )
        
        assertEquals(true, task.isCompleted)
        assertEquals("", task.description) // Default empty description
    }
}
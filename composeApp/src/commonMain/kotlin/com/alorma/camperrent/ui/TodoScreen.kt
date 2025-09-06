package com.alorma.camperrent.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alorma.camperrent.model.TodoTask

@Composable
fun TodoScreen() {
    // Sample TODO tasks
    val todoTasks = remember {
        listOf(
            TodoTask(1, "Plan camper trip route", "Research best camping spots and plan the route", false),
            TodoTask(2, "Check camper equipment", "Inspect tires, brakes, and engine", false),
            TodoTask(3, "Pack camping gear", "Tent, sleeping bags, cooking equipment", false),
            TodoTask(4, "Book campsites", "Reserve spots at national parks", true),
            TodoTask(5, "Prepare food supplies", "Non-perishable items and water", false),
            TodoTask(6, "Download offline maps", "Ensure navigation works without internet", true),
            TodoTask(7, "Emergency kit check", "First aid, tools, spare parts", false)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Header
        Text(
            text = "Camper Rent Checks",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        // TODO List
        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            LazyColumn(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(todoTasks) { task ->
                    TodoTaskItem(
                        task = task,
                        onTaskClick = { /* Handle task click */ }
                    )
                }
            }
        }
    }
}

@Composable
fun TodoTaskItem(
    task: TodoTask,
    onTaskClick: (TodoTask) -> Unit
) {
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = { onTaskClick(task) },
        colors = CardDefaults.elevatedCardColors(
            containerColor = if (task.isCompleted) 
                MaterialTheme.colorScheme.surfaceVariant 
            else 
                MaterialTheme.colorScheme.surface
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = task.isCompleted,
                onCheckedChange = { /* Handle checkbox change */ }
            )
            
            Spacer(modifier = Modifier.width(12.dp))
            
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = task.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    textDecoration = if (task.isCompleted) 
                        TextDecoration.LineThrough 
                    else 
                        TextDecoration.None
                )
                
                if (task.description.isNotEmpty()) {
                    Text(
                        text = task.description,
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textDecoration = if (task.isCompleted) 
                            TextDecoration.LineThrough 
                        else 
                            TextDecoration.None
                    )
                }
            }
        }
    }
}
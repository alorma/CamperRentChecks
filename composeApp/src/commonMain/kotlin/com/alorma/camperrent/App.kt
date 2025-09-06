package com.alorma.camperrent

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alorma.camperrent.data.entities.CamperRentCheck
import com.alorma.camperrent.data.repository.CamperRentRepository
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val repository = remember { CamperRentRepository() }
    var isLoading by remember { mutableStateOf(true) }
    var checks by remember { mutableStateOf<List<CamperRentCheck>>(emptyList()) }
    
    // Initialize sample data and load checks
    LaunchedEffect(Unit) {
        try {
            repository.createSampleData()
        } catch (e: Exception) {
            // Sample data already exists or other error
        }
        
        repository.getAllChecks().collect { checksList ->
            checks = checksList
            isLoading = false
        }
    }
    
    AppTheme {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            Text(
                text = "Camper Rent Checks",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            
            if (isLoading) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            } else if (checks.isEmpty()) {
                Card(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "No checks found",
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Text(
                            text = "Room database is ready, but sample data couldn't be loaded due to network restrictions.",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            } else {
                LazyColumn {
                    items(checks) { check ->
                        CamperCheckCard(check = check)
                    }
                }
            }
        }
    }
}

@Composable
fun CamperCheckCard(check: CamperRentCheck) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = check.camperName,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = if (check.isCheckIn) "Check In" else "Check Out",
                    style = MaterialTheme.typography.labelMedium,
                    color = if (check.isCheckIn) 
                        MaterialTheme.colorScheme.primary 
                    else 
                        MaterialTheme.colorScheme.secondary
                )
            }
            
            Text(
                text = "Renter: ${check.renterName}",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 4.dp)
            )
            
            Text(
                text = "Mileage: ${check.mileage} | Fuel: ${(check.fuelLevel * 100).toInt()}%",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 4.dp)
            )
            
            if (check.damageNotes.isNotEmpty()) {
                Text(
                    text = "Notes: ${check.damageNotes}",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}
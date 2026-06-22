package com.rossmannnn.marketplace.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rossmannnn.marketplace.data.model.FilterCriteria

@Composable
fun HomeScreen() {
    var filterCriteria by remember { mutableStateOf(FilterCriteria()) }
    var isScanning by remember { mutableStateOf(false) }
    var deals by remember { mutableStateOf(emptyList<String>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Header
        Text(
            text = "Marketplace Deal Finder",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Filters Card
        FilterSection(
            criteria = filterCriteria,
            onCriteriaChange = { filterCriteria = it }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Scan Button
        Button(
            onClick = {
                isScanning = true
                // TODO: Implement scanning logic
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            enabled = !isScanning
        ) {
            Icon(Icons.Filled.Search, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = if (isScanning) "Scanning..." else "Start Scanning")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Results Section
        if (deals.isNotEmpty()) {
            Text(
                text = "Good Deals Found (${deals.size})",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            DealsListSection(deals = deals)
        } else if (!isScanning) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentAlignment = Alignment.Center
            ) {
                Text("No deals found. Tap 'Start Scanning' to begin searching.")
            }
        }
    }
}

@Composable
fun FilterSection(
    criteria: FilterCriteria,
    onCriteriaChange: (FilterCriteria) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Product Type
            Text("Product Type", style = MaterialTheme.typography.labelMedium)
            OutlinedTextField(
                value = criteria.productType,
                onValueChange = {
                    onCriteriaChange(criteria.copy(productType = it))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                placeholder = { Text("e.g., Electronics, Furniture") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Price Range
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = criteria.minPrice.toString(),
                    onValueChange = {
                        val price = it.toDoubleOrNull() ?: 0.0
                        onCriteriaChange(criteria.copy(minPrice = price))
                    },
                    modifier = Modifier.weight(1f),
                    label = { Text("Min Price") }
                )
                OutlinedTextField(
                    value = criteria.maxPrice.toString(),
                    onValueChange = {
                        val price = it.toDoubleOrNull() ?: 0.0
                        onCriteriaChange(criteria.copy(maxPrice = price))
                    },
                    modifier = Modifier.weight(1f),
                    label = { Text("Max Price") }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Distance
            Text("Distance (km)", style = MaterialTheme.typography.labelMedium)
            OutlinedTextField(
                value = criteria.distance.toString(),
                onValueChange = {
                    val distance = it.toDoubleOrNull() ?: 0.0
                    onCriteriaChange(criteria.copy(distance = distance))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                label = { Text("Max Distance") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Number of Posts
            Text("Number of Posts to Scan", style = MaterialTheme.typography.labelMedium)
            OutlinedTextField(
                value = criteria.numberOfPosts.toString(),
                onValueChange = {
                    val num = it.toIntOrNull() ?: 10
                    onCriteriaChange(criteria.copy(numberOfPosts = num))
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                label = { Text("Posts") }
            )
        }
    }
}

@Composable
fun DealsListSection(deals: List<String>) {
    Column {
        deals.forEach { deal ->
            DealCard(deal = deal)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun DealCard(deal: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(deal, style = MaterialTheme.typography.bodyMedium)
            }
            Button(onClick = { /* TODO: Open in browser */ }) {
                Text("View")
            }
        }
    }
}
